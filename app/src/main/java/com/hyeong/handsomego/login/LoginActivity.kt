package com.hyeong.handsomego.login

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.hyeong.handsomego.MainActivity
import com.hyeong.handsomego.R
import com.hyeong.handsomego.kakao.SessionCallback
import com.kakao.auth.AuthType
import com.kakao.auth.Session
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v) {
            into_kakao -> {
                val session = Session.getCurrentSession()
                session.addCallback(SessionCallback())
                session.open(AuthType.KAKAO_LOGIN_ALL, this)
                var intent1 : Intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent1)
            }
            into_guest -> {
                var intent1 : Intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent1)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        into_guest.setOnClickListener(this)
        into_kakao.setOnClickListener(this)
    }
}
