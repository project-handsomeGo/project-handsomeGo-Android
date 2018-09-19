package com.hyeong.handsomego

import android.content.Context
import android.content.Intent.getIntent
import android.media.Rating
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.*
import com.bumptech.glide.Glide
import com.hyeong.handsomego.GET.GetSpaceData
import com.hyeong.handsomego.GET.GetSpaceResponse
import org.w3c.dom.Text
import pl.polidea.view.ZoomView
import java.util.zip.Inflater
import com.hyeong.handsomego.NetworkService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeTabMapFragment : Fragment(), View.OnClickListener {

    private var networkService : NetworkService? = null
    private var specificSpaceInfo = ArrayList<GetSpaceData>()

    var v : View? = null
    var zoomView: ZoomView? = null
    var raiting : RatingBar? = null
    var rateText: TextView? = null
    var space_info_layout = view!!.findViewById<RelativeLayout>(R.id.space_info_layout)

    //Relative Layout 가져오기
    var map_space_name = view!!.findViewById<TextView>(R.id.map_space_name)
    var map_space_addr = view!!.findViewById<TextView>(R.id.map_space_addr)
    var star_text = view!!.findViewById<TextView>(R.id.star_text)
    var map_img = view!!.findViewById<ImageView>(R.id.map_img)

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

    //private var networkService : NetworkService? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home_tab_map,container,false)
        val view = (context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE)as LayoutInflater).inflate(R.layout.fragment_hometab_zoomview,null,false)
        val layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)

        networkService = ApplicationController.instance!!.networkService

        zoomView = ZoomView(context)
        zoomView!!.addView(view)
        zoomView!!.layoutParams = layoutParams

        zoomView!!.isMiniMapEnabled = true // 좌측 상단 검은색 미니맵 설정
        zoomView!!.maxZoom = 4f
        zoomView!!.miniMapCaption = "Mini Map Test" // 미니맵 내용
        zoomView!!.miniMapCaptionSize = 20f // 미니맵 내용 글씨 크기 설정

        val container = v!!.findViewById<RelativeLayout>(R.id.mapContainer)
        container.addView(zoomView)

        //클릭 리스너 달기
        yellow1!!.setOnClickListener(this)
        yellow2!!.setOnClickListener(this)
        yellow3!!.setOnClickListener(this)
        yellow4!!.setOnClickListener(this)
        yellow5!!.setOnClickListener(this)
        yellow6!!.setOnClickListener(this)
        yellow7!!.setOnClickListener(this)
        yellow8!!.setOnClickListener(this)

        blue1!!.setOnClickListener(this)
        blue2!!.setOnClickListener(this)
        blue3!!.setOnClickListener(this)
        blue4!!.setOnClickListener(this)
        blue5!!.setOnClickListener(this)
        blue6!!.setOnClickListener(this)
        blue7!!.setOnClickListener(this)
        blue8!!.setOnClickListener(this)

        green1!!.setOnClickListener(this)
        green2!!.setOnClickListener(this)
        green3!!.setOnClickListener(this)
        green4!!.setOnClickListener(this)

        //Rating Bar setting
        raiting = view!!.findViewById(R.id.star_rating)
        rateText = view!!.findViewById(R.id.star_text)

        raiting!!.onRatingBarChangeListener = object : RatingBar.OnRatingBarChangeListener{
            override fun onRatingChanged(ratingBar: RatingBar?, rating: Float, fromUser: Boolean) {
                //rateText!!.setText(raiting.toString())
                raiting!!.rating = rateText!!.text.toString().toFloat()
            }
        }
        return v

    }

    override fun onClick(v: View?) {
        when(v){
            yellow1 ->{ //8
                space_info_layout.visibility = View.VISIBLE
                getSpaceInfo(8)
                Glide.with(this).load(specificSpaceInfo[0].place_pic).into(map_img)
                map_space_name.setText(specificSpaceInfo[0].place_name)
                map_space_addr.setText(specificSpaceInfo[0].place_address)
                star_text.setText(specificSpaceInfo[0].place_star.toString())
            }
            yellow2 ->{ //6
                space_info_layout.visibility = View.VISIBLE
            }
            yellow3 ->{ //7
                space_info_layout.visibility = View.VISIBLE
            }
            yellow4 ->{ //2
                space_info_layout.visibility = View.VISIBLE
            }
            yellow5 ->{ //3
                space_info_layout.visibility = View.VISIBLE
            }
            yellow6 ->{ //1
                space_info_layout.visibility = View.VISIBLE
            }
            yellow7 ->{ //4
                space_info_layout.visibility = View.VISIBLE
            }
            yellow8 ->{ //5
                space_info_layout.visibility = View.VISIBLE
            }
            blue1 -> { //14
                space_info_layout.visibility = View.VISIBLE
            }
            blue2 -> { //16
                space_info_layout.visibility = View.VISIBLE
            }
            blue3 -> { //12
                space_info_layout.visibility = View.VISIBLE
            }
            blue4 -> { //10
                space_info_layout.visibility = View.VISIBLE
            }
            blue5 -> { //9
                space_info_layout.visibility = View.VISIBLE
            }
            blue6 -> { //13
                space_info_layout.visibility = View.VISIBLE
            }
            blue7 -> { //15
                space_info_layout.visibility = View.VISIBLE
            }
            blue8 -> { //11
                space_info_layout.visibility = View.VISIBLE
            }
            green1 ->{ //18
                space_info_layout.visibility = View.VISIBLE
            }
            green2 ->{ //17
                space_info_layout.visibility = View.VISIBLE
            }
            green3 ->{ //20
                space_info_layout.visibility = View.VISIBLE
            }
            green4 ->{ //19
                space_info_layout.visibility = View.VISIBLE
            }
        }
    }

    fun getSpaceInfo(place_id : Int) {
        val spaceInfobyIdResponse = networkService!!.getSpaceInfo(place_id)
        spaceInfobyIdResponse!!.enqueue(object : retrofit2.Callback<GetSpaceResponse> {

            override fun onResponse(call: Call<GetSpaceResponse>?, response: Response<GetSpaceResponse>?) {
                if(response!!.isSuccessful){
                    if(response!!.body().message.equals("Successful Get Place Data")){
                        if (response!!.body().data != null){
                            for(i in 0 .. response!!.body().data.size-1){
                                specificSpaceInfo.add(GetSpaceData(response!!.body().data[i].place_id,
                                        response!!.body().data[i].place_name,
                                        response!!.body().data[i].place_address,
                                        response!!.body().data[i].place_content,
                                        response!!.body().data[i].place_category,
                                        response!!.body().data[i].place_star,
                                        response!!.body().data[i].place_pic,
                                        response!!.body().data[i].commentCount))

                            }
                        }else{
                            Log.v("dek","data is null")
                        }
                    }else{
                        Log.v("dek","Cannot get place data")
                    }
                }else{
                    Log.v("dek","response is not successful")
                }
            }

            override fun onFailure(call: Call<GetSpaceResponse>?, t: Throwable?) {

            }

        })
    }

}