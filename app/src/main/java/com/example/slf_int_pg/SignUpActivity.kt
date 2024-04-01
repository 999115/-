package com.example.slf_int_pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import java.util.Locale

class SignUpActivity : AppCompatActivity() {

    val username: EditText by lazy { findViewById(R.id.et_name_signup) }
    val userid = findViewById<EditText>(R.id.et_id_signup)
    val userpw = findViewById<EditText>(R.id.et_pw_signup)
    val usermbti = findViewById<EditText>(R.id.et_mbti_signup)
    val userintro = findViewById<EditText>(R.id.et_intro_signup)
    val btsignup = findViewById<Button>(R.id.bt_signup_signup)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        userid.setText(intent.getStringExtra("userid"))
        userpw.setText(intent.getStringExtra("userpw"))

        btsignup.setOnClickListener {
            val goSignInActivity = Intent(this, SignInActivity::class.java)

            if (username.text.isEmpty() || userid.text.isEmpty() || userpw.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()

            val idData = userid.text.toString()
            val pwData = userpw.text.toString()
            val nameData = username.text.toString()
            val mbtiData = usermbti.text.toString()
            val introData = userintro.text.toString()

            goSignInActivity.putExtra("userid", idData)
            goSignInActivity.putExtra("userpw", pwData)
            goSignInActivity.putExtra("username", nameData)
            goSignInActivity.putExtra("usermbti", mbtiData)
            goSignInActivity.putExtra("userintro", introData)

            startActivity(goSignInActivity)
        }

    }
}