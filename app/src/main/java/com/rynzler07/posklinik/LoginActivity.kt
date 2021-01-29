package com.rynzler07.posklinik

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    private lateinit var et_username : EditText
    private lateinit var et_password : EditText
    private lateinit var btn_login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        btn_login = findViewById(R.id.btn_login)

        btn_login.setOnClickListener{
            val username = et_username.text.toString()
            val password = et_password.text.toString()
            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Please Insert Email & Password", Toast.LENGTH_SHORT)
                return@setOnClickListener
            }
            if (username == "admin" || password == "admin"){
                val progressDialog = ProgressDialog(this, R.style.Theme_MaterialComponents_Light_Dialog)
                progressDialog.isIndeterminate = true
                progressDialog.setMessage("Loading . . . . ")
                progressDialog.show()
                val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}