package tn.esprit.gamer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import tn.esprit.gamer.R
import tn.esprit.gamer.databinding.ActivityForgetPasswordBinding
import tn.esprit.gamer.databinding.ActivityLoginBinding

class ForgetPasswordActivity : AppCompatActivity() {
    lateinit var binding: ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)

        binding.btnReturn.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            startActivity(Intent(this, OtpValidationActivity::class.java))
        }

        binding.btnSendSMS.setOnClickListener {
            startActivity(Intent(this, OtpValidationActivity::class.java))
        }

    }
}