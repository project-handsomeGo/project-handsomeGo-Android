package com.hyeong.handsomego

import android.support.v4.app.Fragment
import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_hometab.*

class HomeTabFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_hometab,container,false)

        addFragment(HomeTabMapFragment())

        var map_btn = view!!.findViewById<TextView>(R.id.map_btn)
        var rank_btn = view!!.findViewById<TextView>(R.id.rank_btn)

        map_btn!!.setOnClickListener(this)
        rank_btn!!.setOnClickListener(this)

        return v
    }

    override fun onClick(v: View?) {

        when(v){
            map_btn -> {
                replaceFragment(HomeTabMapFragment())
            }
            rank_btn -> {
                replaceFragment(HomeTabRankFragment())
            }
        }
    }

    //Fragment 붙이는 함수
    fun addFragment(fragment: Fragment) : Unit{
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.home_frame, fragment)
        transaction.commit()
    }

    //Fragment 교체
    fun replaceFragment(fragment: android.support.v4.app.Fragment) : Unit{
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.home_frame,fragment)
        transaction.commit()
    }
}