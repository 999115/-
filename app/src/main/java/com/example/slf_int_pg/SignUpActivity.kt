package com.example.slf_int_pg

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.slf_int_pg.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by lazy {
        ViewModelProvider(this)[SignUpViewModel::class.java]
    }

    private lateinit var id: String
    private lateinit var pw: String
    private lateinit var name: String

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etIdSignup.setText(intent.getStringExtra("userid"))
        binding.etPwSignup.setText(intent.getStringExtra("userpw"))

        initView()
        initViewModel()

    }

    private fun initView() {

        binding.btSignupSignup.setOnClickListener {
            viewModel.nameData(binding.etNameSignup.text.toString())
            viewModel.idData(binding.etIdSignup.text.toString())
            viewModel.pwData(binding.etPwSignup.text.toString())

            val goSignInActivity = Intent(this, SignInActivity::class.java)

            if (binding.etNameSignup.text.isEmpty() || binding.etIdSignup.text.isEmpty() || binding.etPwSignup.text.isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

//            Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, name + " " + id + " " + pw, Toast.LENGTH_SHORT).show()



            goSignInActivity.putExtra("userid", binding.etIdSignup.text.toString())
            goSignInActivity.putExtra("userpw", binding.etPwSignup.text.toString())
            goSignInActivity.putExtra("username", binding.etNameSignup.text.toString())
            goSignInActivity.putExtra("usermbti", binding.etMbtiSignup.text.toString())
            goSignInActivity.putExtra("userintro", binding.etIntroSignup.text.toString())

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