package com.hyeong.handsomego.qr_code

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import com.google.zxing.integration.android.IntentResult
import com.hyeong.handsomego.R

class CameraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        IntentIntegrator(this). initiateScan()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val result : IntentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        Toast.makeText(this,result.contents,Toast.LENGTH_LONG).show()
        Log.d("asd",result.contents)
    }
}
