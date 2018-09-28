package com.hyeong.handsomego.kakao

import android.support.v4.content.ContextCompat
import android.util.Log
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.LogoutResponseCallback
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException



class SessionCallback : ISessionCallback{
    // 로그인에 실패
    override fun onSessionOpenFailed(exception: KakaoException?) {
    }

    // 로그인에 성공
    override fun onSessionOpened() {
        requestMe()
    }
    fun requestMe(){
        val user : UserManagement = UserManagement.getInstance()
        user.requestMe(object : MeResponseCallback(){
            override fun onSuccess(result: UserProfile?) {
                val nickname = result!!.nickname
                val profileImagePath = result.profileImagePath
                val UUID = result.uuid
                Log.d("asd",nickname+profileImagePath+UUID)
            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
                Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult!!.errorMessage);
            }

            override fun onNotSignedUp() {
                Log.e("SessionCallback :: ", "onNotSignedUp");
            }
        })
    }
//    fun logout(){
//        val user : UserManagement = UserManagement.getInstance()
//        user.requestLogout(object : LogoutResponseCallback(){
//            override fun onCompleteLogout() {
//                ContextCompat.startActivity()
//            }
//        })
//    }
}