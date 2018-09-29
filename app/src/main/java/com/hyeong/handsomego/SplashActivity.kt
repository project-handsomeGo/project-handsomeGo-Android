package com.hyeong.handsomego

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.hyeong.handsomego.login.LoginActivity


/**
 * Created by HYEON on 2018-09-29.
 */
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val source = findViewById<ImageView>(R.id.splash_gif)
        Glide.with(this)
                .load(R.drawable.handsomego_splash)
                .into(source)

        val handler = Handler()
        handler.postDelayed({
            startActivity(Intent(applicationContext, LoginActivity::class.java))
            finish()
        }, 3000)
    }


}