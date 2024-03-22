package com.example.slf_int_pg

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val userid = findViewById<EditText>(R.id.et_id_signup)
        val userpw = findViewById<EditText>(R.id.et_pw_signup)
        val btsignin = findViewById<Button>(R.id.bt_signin)
        val btsignup = findViewById<Button>(R.id.bt_signup_signup)



        btsignin.setOnClickListener {
            val goHomeActivity = Intent(this, HomeActivity::class.java)

            if (userid.text.isEmpty() || userpw.text.isEmpty()){
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "어서오세요, ${userid.text} 님!", Toast.LENGTH_SHORT).show()

            val idData = userid.text.toString()
            val pwData = userpw.text.toString()

            goHomeActivity.putExtra("userid",idData)
            goHomeActivity.putExtra("userpw",pwData)

            startActivity(goHomeActivity)
        }

        btsignup.setOnClickListener {
            val goSignUpActivity = Intent(this, SignUpActivity::class.java)


            if (userid.text.isEmpty() || userpw.text.isEmpty()){
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idData = userid.text.toString()
            val pwData = userpw.text.toString()

            goSignUpActivity.putExtra("userid",idData)
            goSignUpActivity.putExtra("userpw",pwData)

            startActivity(goSignUpActivity)
        }

    }
}