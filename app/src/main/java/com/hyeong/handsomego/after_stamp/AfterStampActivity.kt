package com.hyeong.handsomego.after_stamp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hyeong.handsomego.Idx
import com.hyeong.handsomego.R
import com.hyeong.handsomego.Token
import com.hyeong.handsomego.applicationController.ApplicationController
import com.hyeong.handsomego.applicationController.NetworkService
import com.hyeong.handsomego.get.GetStampPlaceResponse
import kotlinx.android.synthetic.main.activity_after_stamp.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AfterStampActivity : AppCompatActivity() {

    var networkService : NetworkService = ApplicationController.instance.networkService
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_stamp)

        // Get Stamp of Place Info
        val getPlacePlaceResponse = networkService.getStampPlace(Token.token, Idx.place_id)
        getPlacePlaceResponse.enqueue(object : Callback<GetStampPlaceResponse> {
            override fun onFailure(call: Call<GetStampPlaceResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetStampPlaceResponse>?, response: Response<GetStampPlaceResponse>?) {
                if(response!!.isSuccessful){
                    after_title_tv.text = response.body().data.place_name
                    after_cate_tv.text = response.body().data.place_category
                    after_rank_tv.text = response.body().data.rank.toString()+"위"
                    after_date_tv.text = response.body().data.stamp_date.substring(0,10).replace("-",".")
                    Glide.with(this@AfterStampActivity).load(response.body().data.place_pic).into(after_stamp_circle)
                }
            }

        })
    }
}
