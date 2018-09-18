package com.hyeong.handsomego

import retrofit2.Call
import retrofit2.http.*
import okhttp3.MultipartBody
import okhttp3.RequestBody
import com.hyeong.handsomego.GET.GetSpaceResponse


interface NetworkService {

    //장소 정보 불러오기
    @GET("places")
    fun getSpaceInfo(@Query("place_id") place_id : Int) : Call<GetSpaceResponse>
}