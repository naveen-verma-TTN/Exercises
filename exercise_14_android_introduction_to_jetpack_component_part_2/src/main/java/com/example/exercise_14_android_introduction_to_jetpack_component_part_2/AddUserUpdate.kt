package com.example.exercise_14_android_introduction_to_jetpack_component_part_2

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.model.User
import com.example.exercise_14_android_introduction_to_jetpack_component_part_2.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_add_user_update.*
import kotlinx.android.synthetic.main.fragment_add_user_update.view.*

/**
 * addUser or updateUser details fragment
 */
class AddUserUpdate : DialogFragment(), View.OnClickListener {

    companion object {
        private lateinit var viewModel: ViewModel
        private lateinit var heading: String
        private lateinit var user: User

        @JvmStatic
        fun newInstance(
            _viewModel: ViewModel,
            _title: String,
            _user: User?
        ) =
            AddUserUpdate().apply {
                viewModel = _viewModel
                heading = _title
                if (heading == "updateUser") {
                    user = _user!!
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_user_update, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // update the title of dialog box
        view.title.text = heading

        if (heading == "updateUser") {
            view.name.setText(user.name)
            view.email.setText(user.email)
            view.phone.setText(user.phone)
            view.address.setText(user.address)
        }

        view.delete.setOnClickListener(this)
        view.add_update.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.delete -> this.dismiss()
            R.id.add_update -> {
                if (TextUtils.isEmpty(name.text) or
                    TextUtils.isEmpty(email.text) or
                    TextUtils.isEmpty(phone.text) or
                    TextUtils.isEmpty(address.text)
                ) {
                    Toast.makeText(
                        v.context,
                        getString(R.string.item_error_message),
                        Toast.LENGTH_LONG
                    ).show()

                } else {
                    val userName = view!!.name.text.toString()
                    val userEmail = view!!.email.text.toString()
                    val userPhone = view!!.phone.text.toString()
                    val userAddress = view!!.address.text.toString()
                    if (heading == "updateUser") {
                        val u =
                            User(userName, userEmail, userPhone, userAddress)
                        u.id = user.id
                        viewModel.update(u)
                        Toast.makeText(
                            v.context,
                            userName + " " + getString(R.string.update_message),
                            Toast.LENGTH_LONG
                        ).show()
                    } else {
                        val user =
                            User(userName, userEmail, userPhone, userAddress)
                        viewModel.insert(user)
                        Toast.makeText(
                            v.context,
                            userName + " " + getString(R.string.insert_message),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    this.dismiss()
                }
            }
        }
    }
}
