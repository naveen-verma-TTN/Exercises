package com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.R
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.model.User
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.recylcerview.ListItemClickListener
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.recylcerview.MyAdapter
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.first_question.viewmodel.ViewModel
import kotlinx.android.synthetic.main.activity_first_question_main.*

class FirstQuestionMain : AppCompatActivity(),
    ListItemClickListener {
        private var viewModel: ViewModel? = null

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_first_question_main)

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
            val adapter =
                MyAdapter(
                    this
                )
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