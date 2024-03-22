package com.example.slf_int_pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val username = findViewById<EditText>(R.id.et_name_signup)
        val userid = findViewById<EditText>(R.id.et_id_signup)
        val userpw = findViewById<EditText>(R.id.et_pw_signup)
        val btsignup = findViewById<Button>(R.id.bt_signup_signup)

        btsignup.setOnClickListener {
//            val goSignUpActivity = Intent(this, SignUpActivity::class.java)

//            val idData = userid.text.toString()
//            val pwData = userpw.text.toString()
//
//            goSignUpActivity.putExtra("userid",idData)
//            goSignUpActivity.putExtra("userpw",pwData)

            if (username.text.isEmpty() ||userid.text.isEmpty() || userpw.text.isEmpty()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            finish()
        }

    }
}