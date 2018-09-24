package com.hyeong.handsomego.my_page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R
import com.hyeong.handsomego.Token
import com.hyeong.handsomego.applicationController.ApplicationController
import com.hyeong.handsomego.get.GetStampInfoResponse
import kotlinx.android.synthetic.main.fragment_mypagetab.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by HYEON on 2018-09-03.
 */
class MypageTabFragment : Fragment(), View.OnClickListener {
    lateinit var stampItem: ArrayList<StampItem>
    lateinit var  stampAdapter: StampAdapter
    override fun onClick(v: View?) {
        when (v) {
            stamp_more_btn -> {
                mypage_stamp_relative.visibility = View.VISIBLE
                stamp_nomore_btn.visibility = View.VISIBLE
                stamp_more_btn.visibility = View.GONE
            }
            stamp_nomore_btn -> {
                mypage_stamp_relative.visibility = View.GONE
                stamp_nomore_btn.visibility = View.GONE
                stamp_more_btn.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypagetab,container,false)
        return v
    }

    override fun onStart() {
        super.onStart()

        stamp_more_btn.setOnClickListener(this)
        stamp_nomore_btn.setOnClickListener(this)

        val networkService = ApplicationController.instance.networkService
        val getStampInfoResponse = networkService.getStampInfo(Token.token)
        getStampInfoResponse.enqueue(object : Callback<GetStampInfoResponse> {
            override fun onFailure(call: Call<GetStampInfoResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetStampInfoResponse>?, response: Response<GetStampInfoResponse>?) {
                if(response!!.isSuccessful){
                    Log.d("asd", response.body().data.place[0].place_name)
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