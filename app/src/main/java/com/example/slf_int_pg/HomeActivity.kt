package com.example.slf_int_pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val username = findViewById<TextView>(R.id.tv_name_print)
        val userid = findViewById<TextView>(R.id.tv_id_print)
        val usermbti = findViewById<TextView>(R.id.tv_mbti_print)
        val userintro = findViewById<TextView>(R.id.tv_intro2_print)
        val btEnd = findViewById<Button>(R.id.bt_end)
        val intImage = findViewById<ImageView>(R.id.iv_intro)

        var randomNum = (1..5).random()
        val randomImage = resources.getIdentifier("img_int${randomNum}", "drawable", packageName)

        intImage.setImageResource(randomImage)

        username.text = "이름 : " + intent.getStringExtra("username")
        userid.text = "아이디 : " + intent.getStringExtra("userid")
        usermbti.text = "MBTI : " + intent.getStringExtra("usermbti")
        userintro.text = intent.getStringExtra("userintro")

        btEnd.setOnClickListener {
            finish()
        }

    }
}