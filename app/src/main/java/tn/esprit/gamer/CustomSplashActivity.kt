package tn.esprit.gamer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import tn.esprit.gamer.ui.LoginActivity

@SuppressLint("CustomSplashScreen")
class CustomSplashActivity : AppCompatActivity() {

    private var keep: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        splashScreen.setKeepOnScreenCondition { keep }
        Handler(Looper.getMainLooper()).postDelayed({
            keep = false
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 1000)
    }
}