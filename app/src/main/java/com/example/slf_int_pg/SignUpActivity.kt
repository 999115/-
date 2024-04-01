package com.example.slf_int_pg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by lazy {
        ViewModelProvider(this)[SignUpViewModel::class.java]
    }

    private val userName: EditText by lazy {
        findViewById(R.id.et_name_signup)
    }

    private val userId: EditText by lazy {
        findViewById(R.id.et_id_signup)
    }

    private val userPw: EditText by lazy {
        findViewById(R.id.et_pw_signup)
    }

    private val userMbti: EditText by lazy {
        findViewById(R.id.et_mbti_signup)
    }

    private val userIntro: EditText by lazy {
        findViewById(R.id.et_intro_signup)
    }

    private val btSignUp: Button by lazy {
        findViewById(R.id.bt_signup_signup)
    }

    lateinit var id: String
    lateinit var pw: String
    lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        userId.setText(intent.getStringExtra("userid"))
        userPw.setText(intent.getStringExtra("userpw"))


        initView()
        initViewModel()

    }

    private fun initView() {
        btSignUp.setOnClickListener {
            viewModel.nameData(userName.text.toString())
            viewModel.idData(userId.text.toString())
            viewModel.pwData(userPw.text.toString())

            val goSignInActivity = Intent(this, SignInActivity::class.java)

            if (userName.text.isEmpty() || userId.text.isEmpty() || userPw.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, name + " " + id + " " + pw, Toast.LENGTH_SHORT).show()



            goSignInActivity.putExtra("userid", userId.text.toString())
            goSignInActivity.putExtra("userpw", userPw.text.toString())
            goSignInActivity.putExtra("username", userName.text.toString())
            goSignInActivity.putExtra("usermbti", userMbti.text.toString())
            goSignInActivity.putExtra("userintro", userIntro.text.toString())

            startActivity(goSignInActivity)
        }
    }

    private fun initViewModel() {
        viewModel.nameLiveData.observe(this@SignUpActivity) {
            name = it
        }

        viewModel.idLiveData.observe(this@SignUpActivity) {
            id = it
        }

        viewModel.pwLiveData.observe(this@SignUpActivity) {
            pw = it
        }
    }
}