package com.pavanapp.appatom_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth= FirebaseAuth.getInstance()

        btnSignup.setOnClickListener{

            signUpUser()
        }
    }

    private fun signUpUser() {
        if(etEmailAddress.text.toString().isEmpty()){
            etEmailAddress.error="Please enter email"
            etEmailAddress.requestFocus()
          return
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(etEmailAddress.text.toString()).matches()){
            etEmailAddress.error="Please enter valid Email"
            etEmailAddress.requestFocus()
            return
        }
        if(etPassword.text.toString().isEmpty()){
            etPassword.error="Please enter password"
            return
        }
        auth.createUserWithEmailAndPassword(etEmailAddress.text.toString(), etPassword.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user=auth.currentUser
                    user?.sendEmailVerification()
                        ?.addOnCompleteListener{task->
                            if(task.isSuccessful){
                                startActivity(Intent(this,NameActivity::class.java))
                            }
                        }

                } else {
                    Toast.makeText(baseContext,"Sign Up failed try again",Toast.LENGTH_LONG).show()

                }

            }
    }
}