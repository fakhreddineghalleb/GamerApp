package tn.esprit.gamer.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

const val OTP_EMAIL = "OTP_EMAIL"
const val OTP_MOBILE = "OTP_MOBILE"

class MyStatics {

    companion object{
        fun hideKeyboard(context: Context, view: View) {
            val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}