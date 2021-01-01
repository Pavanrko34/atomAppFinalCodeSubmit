package com.pavanapp.appatom_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_name.*

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        btnContinue.setOnClickListener{
            if(etName.text.toString().isEmpty()){
                etName.error="Please enter Your name"
            }
            else {
                startActivity(Intent(this, LoginActivity::class.java))

            }
        }
    }
}