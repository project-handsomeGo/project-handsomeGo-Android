package com.hyeong.handsomego.my_page


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R

/**
 * Created by HYEON on 2018-09-14.
 */
class StampFragment : Fragment() {

    lateinit var stampItem: ArrayList<StampItem>
    lateinit var  stampAdapter: StampAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.stamp_fragment, container, false)
       // val v : View = View.inflate(activity, R.layout.stamp_fragment, null)
        return v
    }

    override fun onStart() {
        super.onStart()

        val stamp_recycler : RecyclerView = view!!.findViewById(R.id.stamp_recycler)

        stampItem = ArrayList()
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))


        stampAdapter = StampAdapter(stampItem, context!!)
        stamp_recycler.layoutManager = GridLayoutManager(context,4)
        stamp_recycler.adapter = stampAdapter

    }
}