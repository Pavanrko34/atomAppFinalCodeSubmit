package com.pavanapp.appatom_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var imgfirst: ImageView
    lateinit var txtMeditation: TextView
    lateinit var btnGoogle: Button
    lateinit var btnGuest: Button
    lateinit var txtTerms: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imgfirst =findViewById(R.id.imgfirst)
        txtMeditation=findViewById(R.id.txtMeditation)
        btnGoogle =findViewById(R.id.btnGoogle)
        btnGuest=findViewById(R.id.btnGuest)
        txtTerms=findViewById(R.id.txtTerms)


        btnGoogle.setOnClickListener(){
            startActivity( Intent(this,LoginActivity::class.java))

        }
        btnGuest.setOnClickListener{
            startActivity(Intent(this,NameActivity2::class.java))
            Toast.makeText(baseContext,"Welcome",Toast.LENGTH_SHORT).show()
        }
    }
}