/**
 * Convert the Login Application code in Kotlin language.
 */


package com.example.login_application_kotlin

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern


class Login : AppCompatActivity() {

    private val sEmail : String = "Naveen@gmail.com"
    private val sPass : String = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        loginBT.setOnClickListener {
            validate();
        }
        cancelBT.setOnClickListener {
            finish()
        }
    }

    /**
     * function to validate credentials
     */
    private fun validate() {
        if (emailET.length() == 0) {
            emailET.error = getString(R.string.errorEmail);
        } else if (passwordET.length() == 0) {
            passwordET.error = getString(R.string.errorPassword);
        } else if (!validEmail(emailET.text.toString())) {
            emailET.error = getString(R.string.errorEmailInvalid);
        } else {
            login();
        }
    }

    /**
     * function to validate email pattern
     */
    private fun validEmail(email : String): Boolean {
        val pattern: Pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

    /**
     * function to login by validating the sEmail and sPassword
     */

    private fun login() {
        if (emailET.text.toString().equals( sEmail, true) &&
            passwordET.text.toString() == sPass)
        {
            Snackbar.make(loginPage, getString(R.string.successMessage), Snackbar.LENGTH_LONG).show()
        } else {
            Snackbar.make(loginPage, getString(R.string.emailPasswordInvalid), Snackbar.LENGTH_LONG).show()
        }
    }
}
