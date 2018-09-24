package com.hyeong.handsomego.applicationController


import com.hyeong.handsomego.get.GetMoreReviewResponse
import com.hyeong.handsomego.get.GetPlaceInfoResponse
import com.hyeong.handsomego.get.GetStampInfoResponse
import com.hyeong.handsomego.get.GetStampPlaceResponse
import com.hyeong.handsomego.post.PostStampPlaceResponse
import com.hyeong.handsomego.get.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Created by HYEON on 2018-09-19.
 */
interface NetworkService {

    //특정 장소 정보 불러오기
    @GET("places/{place_id}")
    fun getSpaceInfo(@Path("place_id") place_id : Int) : Call<GetSpaceResponse>

    // 댓글 상세 조회
    @GET("comments/{comment_idx}")
    fun getMoreReview(@Path("comment_idx") idx : Int):Call<GetMoreReviewResponse>

    // 장소 세부 조회
    @GET("places/{place_id}")
    fun getPlaceInfo(@Path("place_id") idx : Int):Call<GetPlaceInfoResponse>

    // 장소의 스탬프 조회
    @GET("stamps/{place_id}")
    fun getStampPlace(@Header("Authorization") token : String, @Path("place_id") idx : Int) : Call<GetStampPlaceResponse>

    // 장소의 스탬프 적립
    @POST("stamps/{place_id}")
    fun postStampPlace(@Header("Authorization") token : String, @Path("place_id") idx : Int) : Call<PostStampPlaceResponse>

    // 마이페이지 조회
    @GET("mypage")
    fun getMypage(@Header("Authorization") token : String) : Call<GetMypageResponse>

    // 스탬프 조회
    @GET("stamps")
    fun getStampInfo(@Header("Authorization") token : String) : Call<GetStampInfoResponse>
}