package com.pavanapp.appatom_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        title="Login"

        btnSignup.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))

        }
        btnLogin.setOnClickListener {
            doLogin()
        }

    }

    private fun doLogin() {
        if (etEmailAddress.text.toString().isEmpty()) {
            etEmailAddress.error = "Please enter email"
            etEmailAddress.requestFocus()
            return
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(etEmailAddress.text.toString()).matches()) {
            etEmailAddress.error = "Please enter valid Email"
            etEmailAddress.requestFocus()
            return
        }
        if (etPassword.text.toString().isEmpty()) {
            etPassword.error = "Please enter password"
            return
        }
        auth.signInWithEmailAndPassword(etEmailAddress.text.toString(), etPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    Toast.makeText(
                        baseContext, "Login Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null)
                }
            }
    }


    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(currentUser: FirebaseUser?) {
        if (currentUser != null) {
            if (currentUser.isEmailVerified) {
                startActivity(Intent(this, HomeActivity::class.java))
               finish()
            } else {
                Toast.makeText(
                    baseContext,
                    "Please verify your email address first",
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            Toast.makeText(
                baseContext,
                "Login Failed/check details",
                Toast.LENGTH_LONG
            ).show()

        }


    }
}