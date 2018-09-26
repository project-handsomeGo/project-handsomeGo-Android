package com.hyeong.handsomego.detail

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.ActionBar
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hyeong.handsomego.Idx
import com.hyeong.handsomego.Info
import com.hyeong.handsomego.R
import com.hyeong.handsomego.Token
import com.hyeong.handsomego.applicationController.ApplicationController
import com.hyeong.handsomego.applicationController.NetworkService
import com.hyeong.handsomego.get.GetMypageResponse
import com.hyeong.handsomego.get.GetPlaceInfoResponse
import com.hyeong.handsomego.get.GetReviewResponse
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.title_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {
    var networkService : NetworkService = ApplicationController.instance.networkService
    lateinit var requestManager : RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        requestManager = Glide.with(this)

        // 액션바 애니메이션 설정
        setSupportActionBar(detail_toolbar)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.title_layout)
        detail_toolbar.setContentInsetsAbsolute(0,0);   // ActionBar Padding 제거
        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset <= -1 * dpToPx(126.5f, applicationContext)) {
                detail_line_view.visibility = View.VISIBLE
                detail_toolbar.visibility = View.VISIBLE
            } else {
                detail_line_view.visibility = View.INVISIBLE
                detail_toolbar.visibility = View.INVISIBLE
            }
        }
        detail_appbar.addOnOffsetChangedListener(listener)

        // 닉네임 가져오기 위한 통신
        val getMypageResponse = networkService.getMypage(Token.token)
        getMypageResponse.enqueue(object : Callback<GetMypageResponse>{
            override fun onFailure(call: Call<GetMypageResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMypageResponse>?, response: Response<GetMypageResponse>?) {
                if(response!!.isSuccessful){
                    Info.name = response.body().data.name
                }
            }
        })

        // 장소 정보 통신
        val getPlaceInfoResponse = networkService.getPlaceInfo(Idx.place_id)
        getPlaceInfoResponse.enqueue(object : Callback<GetPlaceInfoResponse> {
            override fun onFailure(call: Call<GetPlaceInfoResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetPlaceInfoResponse>?, response: Response<GetPlaceInfoResponse>?) {
                if (response!!.isSuccessful) {
                    detail_name_tv.text = response.body().data.place_name
                    detail_title_tv.text = response.body().data.place_name
                    detail_address_tv.text = response.body().data.place_address
                    detail_tag_tv.text = response.body().data.place_category.replace(" ","")
                    detail_explain_tv.text = response.body().data.place_content
                    detail_avg_tv.text = response.body().data.place_star.toFloat().toString()
                    detail_avg_rating.rating = response.body().data.place_star.toFloat()
                    detail_count_tv.text = "리뷰 " + response.body().data.commentCount.toString() + "개"
                    requestManager.load(response.body().data.place_pic).into(detail_img_iv)
                }
            }
        })

        // 리뷰 정보 통신
        val getReviewResponse = networkService.getReview(Token.token, Idx.place_id)
        getReviewResponse.enqueue(object : Callback<GetReviewResponse>{
            override fun onFailure(call: Call<GetReviewResponse>?, t: Throwable?) {
                Log.d("asd",t.toString())
            }

            override fun onResponse(call: Call<GetReviewResponse>?, response: Response<GetReviewResponse>?) {
                if(response!!.isSuccessful){
                    if(response.body().data.message == "로그인 해주세요."){
                        detail_rate_relative.visibility = View.GONE
                    }else{
                        detail_rate_tv.text = Info.name + "님 평가해주세요."
                        if(response.body().data.status == "스탬프를 먼저 찍어주세요."){
                            detail_rate_rating.visibility = View.GONE
                            detail_stamp_btn.visibility = View.VISIBLE
                        }
                    }
                    // 리뷰 "최대" 3개 가져오기
                }
            }
        })
    }
    fun dpToPx(dp: Float, context: Context): Float {
        return (dp * context.resources.displayMetrics.density)
    }
}
