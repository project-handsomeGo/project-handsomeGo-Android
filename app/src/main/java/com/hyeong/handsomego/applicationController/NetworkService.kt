package com.hyeong.handsomego.applicationController


import com.hyeong.handsomego.get.GetStampInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by HYEON on 2018-09-19.
 */
interface NetworkService {

    //마이페이지 조회
    //@GET()

    //스탬프조회 성공
    @GET("stamps")
    fun getStampInfo(@Header("Authorization") token : String) : Call<GetStampInfoResponse>
}