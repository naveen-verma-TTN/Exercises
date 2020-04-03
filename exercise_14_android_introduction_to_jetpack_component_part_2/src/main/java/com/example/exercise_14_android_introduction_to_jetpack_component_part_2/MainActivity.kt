/**
 *  1.Create Application using recycler view, fragments and data binding to show a list
 *      of user with name, Email,Phone Number etc with Some data.
 *      Click on floating action button should show a fragment to add user
 *      details -> Clicking on save should insert in DB (use live data to get the
 *      list of users and be observed by the view).
 */
package com.example.exercise_14_android_introduction_to_jetpack_component_part_2

import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model.User
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ListItemClickListener {
    private var viewModel: ViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_main)

        initRecycler()

        add.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.addToBackStack(null)
            val dialogFragment = AddUserUpdate.newInstance(
                viewModel!!,
                "AddUser",
                null
            )
            dialogFragment.show(transaction, null)
        }
    }

    /**
     * Setting up recycler view
     */
    private fun initRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        val adapter = MyAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProviders.of(this)
            .get(ViewModel::class.java)

        viewModel!!.allUsers.observe(
            this,
            Observer { users ->
                adapter.setList(users)
                adapter.notifyDataSetChanged()
            })
    }

    /**
     * Delete callback handler
     */
    override fun onDeleteUser(user: User?) {
        viewModel!!.delete(user)
        Toast.makeText(
                this,
                user!!.name + " " + getString(R.string.delete_message),
                Toast.LENGTH_LONG
            )
            .show()
    }

    /**
     * Update callback handler
     */
    override fun onUpdateUser(user: User?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.addToBackStack(null)
        val dialogFragment = AddUserUpdate.newInstance(
            viewModel!!,
            "updateUser",
            user!!
        )
        dialogFragment.show(transaction, null)
    }
}