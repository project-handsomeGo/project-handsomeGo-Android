package com.hyeong.handsomego.detail

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v7.app.ActionBar
import android.view.View
import com.hyeong.handsomego.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setSupportActionBar(detail_toolbar)

        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.title_layout)
        detail_toolbar.setContentInsetsAbsolute(0,0);   // ActionBar Padding 제거
        val listener = AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (verticalOffset <= -1 * dpToPx(126.5f, applicationContext)) {
                detail_toolbar.visibility = View.VISIBLE
            } else {
                detail_toolbar.visibility = View.INVISIBLE
            }
        }
        detail_appbar.addOnOffsetChangedListener(listener)
    }
    fun dpToPx(dp: Float, context: Context): Float {
        return (dp * context.resources.displayMetrics.density)
    }
}
