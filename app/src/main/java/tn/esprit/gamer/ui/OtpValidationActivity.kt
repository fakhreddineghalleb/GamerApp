package tn.esprit.gamer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import tn.esprit.gamer.R
import tn.esprit.gamer.databinding.ActivityForgetPasswordBinding
import tn.esprit.gamer.databinding.ActivityOtpValidationBinding
import tn.esprit.gamer.utils.MyStatics
import tn.esprit.gamer.utils.OTP_EMAIL
import tn.esprit.gamer.utils.OTP_MOBILE

class OtpValidationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpValidationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpValidationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val contextView = findViewById<View>(R.id.context_view)

        binding.tiCode1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.tiCode1.text.toString().length==1){
                    binding.tiCode2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.tiCode2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.tiCode2.text.toString().length==1){
                    binding.tiCode3.requestFocus()
                }else{
                    binding.tiCode1.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.tiCode3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.tiCode3.text.toString().length==1){
                    binding.tiCode4.requestFocus()
                }else{
                    binding.tiCode2.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.tiCode4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                return
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binding.tiCode4.text.toString().isEmpty()){
                    binding.tiCode3.requestFocus()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                return
            }
        })

        binding.btnReturn.setOnClickListener {
            finish()
        }

        binding.btnVerify.setOnClickListener {
            MyStatics.hideKeyboard(this, binding.btnVerify)
            if (checkOTP()){
                startActivity(Intent(this, ResetPasswordActivity::class.java))
            }else{
                Snackbar.make(contextView, getString(R.string.msg_error_wrong_code), Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnResendCode.setOnClickListener {
            Snackbar.make(contextView, getString(R.string.msg_coming_soon), Snackbar.LENGTH_SHORT).show()
        }

    }

    private fun checkOTP(): Boolean {

        if (binding.tiCode1.text.toString().length == 1
            && binding.tiCode2.text.toString().length == 1
            && binding.tiCode3.text.toString().length == 1
            && binding.tiCode4.text.toString().length == 1){

            val newOTP = binding.tiCode1.text.toString().toInt() * 1000 + binding.tiCode2.text.toString().toInt() * 100 + binding.tiCode3.text.toString().toInt() * 10 + binding.tiCode4.text.toString().toInt()

            var otpValidation = 0

            if (intent.hasExtra(OTP_MOBILE))
                otpValidation = intent.getIntExtra(OTP_MOBILE, 0)
            else
                otpValidation = intent.getIntExtra(OTP_EMAIL, 0)

            if (otpValidation == newOTP)
                return true
        }

        return false
    }

}