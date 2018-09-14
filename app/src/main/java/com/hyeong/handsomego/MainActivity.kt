package com.hyeong.handsomego

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity(), View.OnClickListener {


    var btn: ImageView? = null
    var iv: ImageView? = null

    override fun onClick(v: View?) {

        when(v) {
            main_icon -> {
                replaceFragment(HomeTabFragment())
            }
            qrcode_icon -> {
                val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(intent)
                setup()
            }
            mypage_icon -> {
                replaceFragment(MypageTabFragment())
            }
        }

                    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeTabFragment())

        main_icon.setOnClickListener(this)
        qrcode_icon.setOnClickListener(this)
        mypage_icon.setOnClickListener(this)

        //setup()

    }

    //Fragment 붙이는 함수
    fun addFragment(fragment: android.support.v4.app.Fragment) : Unit{
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.main_frame,fragment)
        transaction.commit()
    }

    //Fragment 교체
    fun replaceFragment(fragment: android.support.v4.app.Fragment) : Unit{
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame,fragment)
        transaction.commit()
    }

    private fun setup() {
        btn = findViewById(R.id.qrcode_icon) as ImageView
        iv = findViewById(R.id.iv) as ImageView
    }

}
