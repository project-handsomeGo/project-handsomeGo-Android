package com.hyeong.handsomego.my_page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R
import kotlinx.android.synthetic.main.fragment_mypagetab.*

/**
 * Created by HYEON on 2018-09-03.
 */
class MypageTabFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            stamp_more_btn -> {
                stamp_more_btn.isSelected = true
                //addFragment(StampFragment())
                val fragmentTransaction = fragmentManager!!.beginTransaction()
                fragmentTransaction.replace(R.id.mypage_frame, StampFragment()).commit()

                stamp_more_btn.isSelected = false
                fragmentTransaction.remove(StampFragment())
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypagetab,container,false)
        return v
    }

    override fun onOptionsMenuClosed(menu: Menu?) {
        super.onOptionsMenuClosed(menu)
    }

    override fun onStart() {
        super.onStart()

        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.mypage_frame, StampFragment()).commit()
        stamp_more_btn.setOnClickListener(this)


    }

}