package com.hyeong.handsomego.home

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R

/**
 * Created by HYEON on 2018-09-24.
 */

class HomeTabRankFragment : Fragment(), View.OnClickListener{
    override fun onClick(v: View?) {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_tab_rank, container, false)
        return v
    }
}