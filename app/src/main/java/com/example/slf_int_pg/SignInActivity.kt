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

        val et_userid = findViewById<EditText>(R.id.et_id_signup)
        val et_userpw = findViewById<EditText>(R.id.et_pw_signup)
        val bt_signin = findViewById<Button>(R.id.bt_signin)
        val bt_signup = findViewById<Button>(R.id.bt_signup_signup)


        val userid = intent.getStringExtra("userid")
        val userpw = intent.getStringExtra("userpw")
        val username = intent.getStringExtra("username")
        val usermbti = intent.getStringExtra("usermbti")
        val userintro = intent.getStringExtra("userintro")

        bt_signin.setOnClickListener {
            val goHomeActivity = Intent(this, HomeActivity::class.java)

            if (et_userid.text.isEmpty() || et_userpw.text.isEmpty()) {
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (et_userid.text.toString() != userid) {
                Toast.makeText(this, "존재하지 않는 회원정보입니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (et_userpw.text.toString() != userpw) {
                Toast.makeText(this, "아이디와 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "어서오세요, ${username} 님!", Toast.LENGTH_SHORT).show()

            goHomeActivity.putExtra("userid", userid)
            goHomeActivity.putExtra("username", username)
            goHomeActivity.putExtra("usermbti", usermbti)
            goHomeActivity.putExtra("userintro", userintro)

            startActivity(goHomeActivity)
        }

        bt_signup.setOnClickListener {
            val goSignUpActivity = Intent(this, SignUpActivity::class.java)


            if (et_userid.text.isEmpty() || et_userpw.text.isEmpty()) {
                Toast.makeText(this, "아이디와 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idData = et_userid.text.toString()
            val pwData = et_userpw.text.toString()

            goSignUpActivity.putExtra("userid", idData)
            goSignUpActivity.putExtra("userpw", pwData)

            startActivity(goSignUpActivity)
            finish()
        }

    }
}