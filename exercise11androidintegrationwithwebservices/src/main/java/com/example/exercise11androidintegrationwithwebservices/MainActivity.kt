/**
    1. Set background image of any layout. (via Glide and via HTTP URL connection)
        https://image.freepik.com/free-photo/image-human-brain_99433-298.jpg

    2. Create a list by parsing below url, using both Retrofit & HttpURLConnection
        https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json
 */

package com.example.exercise11androidintegrationwithwebservices

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.uiThread
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {
    private companion object {
        private const val TAG = "MainActivity"
    }

    private val gson = Gson()

    private val imageUrl = "https://image.freepik.com/free-photo/image-human-brain_99433-298.jpg"
    private val listUrl =
        "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * function to update the UI after downloading the image using Glide or Http Api
     */
    private fun updateUI(resource: Drawable) {
        Toast.makeText(applicationContext, "Downloaded", Toast.LENGTH_LONG).show()

        layout.background = resource
        textView.setTextColor(Color.WHITE)
        textView2.setTextColor(Color.WHITE)
    }

    /**
     * function to download the image using Glide
     */
    fun downloadImageGlide(view: View) {
        Glide.with(this).load(imageUrl)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                ) {
                    updateUI(resource)
                }
            })
    }

    /**
     * function to download the image using Http Api
     */
    fun downloadImageHttpApi(view: View) {
        val dialog = indeterminateProgressDialog("Downloading")
        doAsync {
            dialog.show()
            println("Downloading");
            val url = URL(imageUrl);

            val urlConnection = url.openConnection() as HttpURLConnection

            try {
                val input: InputStream = BufferedInputStream(urlConnection.inputStream);
                val bitmap = BitmapFactory.decodeStream(input)
                val drawable = BitmapDrawable(resources, bitmap)

                uiThread {
                    updateUI(drawable)
                }

            } catch (e: IOException) {
                Log.e(TAG, e.toString())
            } finally {
                urlConnection.disconnect()
                dialog.dismiss()
            }
        }
    }

    /**
     * function to download the Json and Parse the Json object using Gson
     * and send the Parsable "MyData" class object to RecycleView class
     */
    fun downloadListUsingHttpApi(view: View) {
        val dialog = indeterminateProgressDialog("Downloading")
        doAsync {
            dialog.show()

            val json = URL(listUrl).readText()

            try {
                val data = gson.fromJson(json, MyData::class.java)
                val intent = Intent(applicationContext, RecyclerViewClass::class.java)
                intent.putExtra(RecyclerViewClass.MYDATA, data)
                startActivity(intent)

            } catch (e: IOException) {
                Log.e(TAG, e.toString())
            } finally {
                dialog.dismiss()
            }
        }
    }

    /**
     * function to download the Json using RetroFit Api
     * and send the Parsable "MyData" class object to RecycleView class
     */
    fun downloadListUsingRetroFit(view: View) {
        val call: Call<MyData> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<MyData> {
            override fun onResponse(call: Call<MyData>?, response: Response<MyData>?) {

                val data: MyData = response!!.body()!!

                val intent = Intent(applicationContext, RecyclerViewClass::class.java)
                intent.putExtra(RecyclerViewClass.MYDATA, data)

                startActivity(intent)
            }

            override fun onFailure(call: Call<MyData>?, t: Throwable?) {
                Log.e(TAG, "Exception: " + t.toString())
            }
        })
    }
}

