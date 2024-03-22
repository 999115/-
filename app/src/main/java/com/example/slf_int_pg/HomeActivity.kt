package com.example.slf_int_pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = findViewById<TextView>(R.id.tv_name_print)
        val userid = findViewById<TextView>(R.id.tv_id_print)
        val usermbti = findViewById<TextView>(R.id.tv_mbti_print)
        val btEnd = findViewById<Button>(R.id.bt_end)

        username.text = "이름 : " + intent.getStringExtra("userid")
        userid.text = "아이디 : " + intent.getStringExtra("userid")
        usermbti.text = "MBTI : " + intent.getStringExtra("userid")

        btEnd.setOnClickListener {
            finish()
        }

    }
}