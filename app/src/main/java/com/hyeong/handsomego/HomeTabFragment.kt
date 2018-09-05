package com.hyeong.handsomego

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pl.polidea.view.ZoomView


class HomeTabFragment : Fragment() {

    var v : View? = null
    var zoomView: ZoomView? = null

    //private var networkService : NetworkService? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_hometab,container,false)
        val view = (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater).inflate(R.layout.fragment_hometab_zoomview,null,false)


        return v

    }
}