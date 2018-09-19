package com.hyeong.handsomego.my_page


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R
import com.hyeong.handsomego.applicationController.ApplicationController
import com.hyeong.handsomego.applicationController.NetworkService
import com.hyeong.handsomego.get.GetStampInfoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by HYEON on 2018-09-14.
 */
class StampFragment : Fragment() {

    lateinit var networkService : NetworkService
    lateinit var stampItem: ArrayList<StampItem>
    lateinit var  stampAdapter: StampAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.stamp_fragment, container, false)
        return v
    }

    override fun onStart() {
        super.onStart()
        networkService = ApplicationController.instance.networkService
        val getStampInfoResponse = networkService.getStampInfo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo0MiwiaWF0IjoxNTM3MzYxNDI1LCJleHAiOjE1Mzk5NTM0MjV9.GNSbBt28VaJPlISjzP82WUhHONpAfR-VgLC84cZxhD0")
        getStampInfoResponse.enqueue(object : Callback<GetStampInfoResponse> {
            override fun onFailure(call: Call<GetStampInfoResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetStampInfoResponse>?, response: Response<GetStampInfoResponse>?) {
                if(response!!.isSuccessful){
                    Log.d("asd", response.body().data[0].place[0].place_name)
                }
            }


        })
        val stamp_recycler : RecyclerView = view!!.findViewById(R.id.stamp_recycler)

        stampItem = ArrayList()
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))
        stampItem.add(StampItem(R.drawable.brown))


        stampAdapter = StampAdapter(stampItem, context!!)
        stamp_recycler.layoutManager = GridLayoutManager(context,5)
        stamp_recycler.adapter = stampAdapter

    }
}