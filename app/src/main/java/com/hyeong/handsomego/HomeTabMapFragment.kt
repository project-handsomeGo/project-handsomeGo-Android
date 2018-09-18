package com.hyeong.handsomego

import android.content.Context
import android.media.Rating
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import android.widget.*
import org.w3c.dom.Text
import pl.polidea.view.ZoomView
import java.util.zip.Inflater

class HomeTabMapFragment : Fragment(), View.OnClickListener {


    var v : View? = null
    var zoomView: ZoomView? = null
    var raiting : RatingBar? = null
    var rateText: TextView? = null

    //private var networkService : NetworkService? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_tab_map,container,false)
        val view = (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater).inflate(R.layout.fragment_hometab_zoomview,null,false)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        zoomView = ZoomView(context)
        zoomView!!.addView(view)
        zoomView!!.layoutParams = layoutParams

        zoomView!!.isMiniMapEnabled = true // 좌측 상단 검은색 미니맵 설정
        zoomView!!.maxZoom = 4f
        zoomView!!.miniMapCaption = "Mini Map Test" // 미니맵 내용
        zoomView!!.miniMapCaptionSize = 20f // 미니맵 내용 글씨 크기 설정

        val container = v!!.findViewById<RelativeLayout>(R.id.mapContainer)
        container.addView(zoomView)

        // 버튼 가져오기 yellow section
        var yellow1 = view!!.findViewById<Button>(R.id.yellow1)
        var yellow2 = view!!.findViewById<Button>(R.id.yellow2)
        var yellow3 = view!!.findViewById<Button>(R.id.yellow3)
        var yellow4 = view!!.findViewById<Button>(R.id.yellow4)
        var yellow5 = view!!.findViewById<Button>(R.id.yellow5)
        var yellow6 = view!!.findViewById<Button>(R.id.yellow6)
        var yellow7 = view!!.findViewById<Button>(R.id.yellow7)
        var yellow8 = view!!.findViewById<Button>(R.id.yellow8)
        //버튼 가져오기 blue section
        var blue1 = view!!.findViewById<Button>(R.id.blue1)
        var blue2 = view!!.findViewById<Button>(R.id.blue2)
        var blue3 = view!!.findViewById<Button>(R.id.blue3)
        var blue4 = view!!.findViewById<Button>(R.id.blue4)
        var blue5 = view!!.findViewById<Button>(R.id.blue5)
        var blue6 = view!!.findViewById<Button>(R.id.blue6)
        var blue7 = view!!.findViewById<Button>(R.id.blue7)
        var blue8 = view!!.findViewById<Button>(R.id.blue8)
        //버튼 가져오기 green section
        var green1 = view!!.findViewById<Button>(R.id.green1)
        var green2 = view!!.findViewById<Button>(R.id.green2)
        var green3 = view!!.findViewById<Button>(R.id.green3)
        var green4 = view!!.findViewById<Button>(R.id.green4)

        //클릭 리스너 달기
        yellow1!!.setOnClickListener(this)
        yellow2!!.setOnClickListener(this)
        yellow3!!.setOnClickListener(this)
        yellow4!!.setOnClickListener(this)
        yellow5!!.setOnClickListener(this)
        yellow6!!.setOnClickListener(this)
        yellow7!!.setOnClickListener(this)
        yellow8!!.setOnClickListener(this)

        //Rating Bar setting
        raiting = view!!.findViewById(R.id.star_rating)
        rateText = view!!.findViewById(R.id.star_text)

        raiting!!.onRatingBarChangeListener = object : RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                rateText!!.setText(raiting.toString())
            }
        };



        return v

    }

    override fun onClick(v: View?) {

    }
}