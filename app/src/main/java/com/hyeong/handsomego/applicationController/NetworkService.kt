package com.hyeong.handsomego.applicationController


import com.hyeong.handsomego.get.GetPlaceInfoResponse
import com.hyeong.handsomego.get.GetStampInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

/**
 * Created by HYEON on 2018-09-19.
 */
interface NetworkService {

    @GET("places/{place_id}")
    fun getPlaceInfo(@Path("place_id") idx : Int):Call<GetPlaceInfoResponse>

    //마이페이지 조회
    //@GET()

    //스탬프조회 성공
    @GET("stamps")
    fun getStampInfo(@Header("Authorization") token : String) : Call<GetStampInfoResponse>
}