package tn.esprit.gamer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import com.google.android.material.snackbar.Snackbar
import tn.esprit.gamer.R
import tn.esprit.gamer.databinding.ActivityForgetPasswordBinding
import tn.esprit.gamer.databinding.ActivityLoginBinding
import tn.esprit.gamer.utils.MyStatics
import tn.esprit.gamer.utils.OTP_EMAIL
import tn.esprit.gamer.utils.OTP_MOBILE

class ForgetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)

        binding.tiEmail.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                validateEmail()
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.btnReturn.setOnClickListener {
            finish()
        }

        binding.btnSubmit.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnSubmit)
            if (validateEmail()){
                startActivity(Intent(this, OtpValidationActivity::class.java).apply {
                    putExtra(OTP_EMAIL, 1234)
                })
            }else{
                Snackbar.make(contextView, getString(R.string.msg_error_inputs), Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnSendSMS.setOnClickListener {
            startActivity(Intent(this, OtpValidationActivity::class.java).apply {
                putExtra(OTP_MOBILE, 6789)
            })
        }

    }

    private fun validateEmail(): Boolean {
        binding.tiEmailLayout.isErrorEnabled = false

        if (binding.tiEmail.text.toString().isEmpty()) {
            binding.tiEmailLayout.error = getString(R.string.msg_must_not_be_empty)
            binding.tiEmail.requestFocus()
            return false
        }else{
            binding.tiEmailLayout.isErrorEnabled = false
        }

        if (Patterns.EMAIL_ADDRESS.matcher(binding.tiEmail.text.toString()).matches()) {
            binding.tiEmailLayout.error = getString(R.string.msg_check_your_email)
            binding.tiEmail.requestFocus()
            return false
        }else{
            binding.tiEmailLayout.isErrorEnabled = false
        }

        return true
    }
}