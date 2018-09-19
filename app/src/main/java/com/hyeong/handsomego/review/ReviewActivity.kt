package com.hyeong.handsomego.review

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import com.hyeong.handsomego.R
import kotlinx.android.synthetic.main.activity_review.*

class ReviewActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)
        reviewing_rate_rating.onRatingBarChangeListener = this
    }
}
