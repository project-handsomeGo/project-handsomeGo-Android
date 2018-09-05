package com.hyeong.handsomego.my_page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R

/**
 * Created by HYEON on 2018-09-03.
 */
class MypageTabFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypagetab,container,false)
        return v

    }
}