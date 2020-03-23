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
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.uiThread
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL


class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val imageUrl = "https://image.freepik.com/free-photo/image-human-brain_99433-298.jpg"
    private val listUrl =
        "https://storage.googleapis.com/network-security-conf-codelab.appspot.com/v2/posts.json"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun downloadImageGlide(view: View) {
        Glide.with(this).load(imageUrl)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                ) {
                    Log.e(TAG, "Downloaded")

                    Toast.makeText(applicationContext, "Downloaded", Toast.LENGTH_LONG).show()

                    layout.background = resource
                    textView.setTextColor(Color.WHITE)
                    textView2.setTextColor(Color.WHITE)
                }
            })
    }

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
                val d = BitmapDrawable(resources, bitmap)

                uiThread {
                    Log.e(TAG, "Downloaded")

                    Toast.makeText(applicationContext, "Downloaded", Toast.LENGTH_LONG).show()
                    layout.background = d
                    textView.setTextColor(Color.WHITE)
                    textView2.setTextColor(Color.WHITE)
                }


            } catch (e: IOException) {
                Log.e(TAG, e.toString())
            } finally {
                urlConnection.disconnect()
                dialog.dismiss()
            }
        }
    }


    fun downloadListUsingHttpApi(view: View) {
        val dialog = indeterminateProgressDialog("Downloading")
        doAsync {
            dialog.show()
            println("Downloading");
            val json = URL(listUrl).readText()

            try {
                uiThread {
                    val intent = Intent(applicationContext, RecycleViewClass::class.java)
                    intent.putExtra("JSON", json)
                    startActivity(intent)
                }
            } catch (e: IOException) {
                Log.e(TAG, e.toString())
            } finally {
                dialog.dismiss()
            }
        }
    }

    fun downloadListUsingRetroFit(view: View) {
       /* val call: Call<MyDataClass> = ApiClient.getClient.getData()
        call.enqueue(object : Callback<MyDataClass> {
            override fun onResponse(call: Call<MyDataClass>?, response: Response<MyDataClass>?) {

                // dataList.addAll(response!!.body()!!)
                Log.e(TAG, "Result : " + response!!.body()!!.toString())
                val json = response.body()!!.toString()
                val intent = Intent(applicationContext, RecycleViewClass::class.java)

                Log.e(TAG, "fdddfd: " + json)

              *//*  intent.putExtra("JSON", json)
                startActivity(intent)*//*

            }

            override fun onFailure(call: Call<MyDataClass>?, t: Throwable?) {
                Log.e(TAG, "Exception: " + t.toString())
            }

        })*/
    }

}

