package com.example.ti20

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        register_button_register.setOnClickListener {
            val email = email_edittext_register.text.toString()
            val password = password_edittext_register.text.toString()

            Log.d("MainActivity", "Email is: " + email)
            Log.d("MainActivity", "Password: $password")


            //Firebase
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{
                    if (!it.isSuccessful) return@addOnCompleteListener
                    //else success
                    Log.d("Login","Successfully logged in: ${it.result!!.user.uid}")
                }
        }
        already_have_text_view.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            // déclenche le login activity en gros
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
