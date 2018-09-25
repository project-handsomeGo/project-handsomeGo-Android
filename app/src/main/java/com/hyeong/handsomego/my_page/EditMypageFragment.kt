package com.hyeong.handsomego.my_page

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.hyeong.handsomego.R
import com.hyeong.handsomego.Token
import com.hyeong.handsomego.applicationController.ApplicationController
import com.hyeong.handsomego.get.GetMypageResponse
import com.hyeong.handsomego.get.GetStampInfoResponse
import com.hyeong.handsomego.put.PutEditResponse
import com.hyeong.handsomego.put.PutEditResponseData
import kotlinx.android.synthetic.main.fragment_edit_mypage.*
import kotlinx.android.synthetic.main.fragment_mypagetab.*
import kotlinx.android.synthetic.main.fragment_mypagetab.view.*
import okhttp3.MediaType
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditMypageFragment : Fragment(), View.OnClickListener {
    val networkService = ApplicationController.instance.networkService

    override fun onClick(v: View?) {
        when (v) {
            edit_pic_iv -> {
                // 사진 업로드 통신
//                TODO("picture값에 사진 넘기기")
//                val putEditResponse = networkService.putMypage(Token.token, PutEditResponseData(null,null))
//                putEditResponse.enqueue(object : Callback<PutEditResponse>{
//                    override fun onFailure(call: Call<PutEditResponse>?, t: Throwable?) {
//                    }
//
//                    override fun onResponse(call: Call<PutEditResponse>?, response: Response<PutEditResponse>?) {
//                        if(response!!.isSuccessful)
//                            Toast.makeText(context,"사진 업로드 완료",Toast.LENGTH_LONG)
//                    }
//                })
            }
            edit_nickname_iv -> {
                // 닉네임 변경 적용 통신
                val putEditResponse = networkService.putMypage(Token.token, PutEditResponseData(edit_nickname_et.text.toString(),null))
                putEditResponse.enqueue(object : Callback<PutEditResponse>{
                    override fun onFailure(call: Call<PutEditResponse>?, t: Throwable?) {
                        Log.d("asd",t.toString())
                    }

                    override fun onResponse(call: Call<PutEditResponse>?, response: Response<PutEditResponse>?) {
                        if (response!!.isSuccessful)
                            Toast.makeText(context,"닉네임 변경 완료",Toast.LENGTH_LONG)
                    }
                })
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_edit_mypage,container,false)
        return v
    }

    override fun onStart() {
        super.onStart()

        edit_pic_iv.setOnClickListener(this)
        edit_nickname_iv.setOnClickListener(this)

        // 프로필 사진, 닉네임 가져오기
        val getMypageResponse = networkService.getMypage(Token.token)
        getMypageResponse.enqueue(object : Callback<GetMypageResponse>{
            override fun onFailure(call: Call<GetMypageResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMypageResponse>?, response: Response<GetMypageResponse>?) {
                if(response!!.isSuccessful){
                    Glide.with(context).load(response.body().data.picture).into(edit_profile_circle)
                    edit_nickname_et.text = Editable.Factory.getInstance().newEditable(response.body().data.name)
                }
            }
        })
    }
}
