package com.textile.markeet.views.activities

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.textile.markeet.R
import com.textile.markeet.helpers.AppConstants
import com.textile.markeet.helpers.AppPreference

import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (AppPreference.getInstance(this).getString(AppConstants.TOKEN) != null)
            startActivity(Intent(this, MainActivity::class.java))
        else
            startActivity(Intent(this, SigninActivity::class.java))

        finish()
    }

}
