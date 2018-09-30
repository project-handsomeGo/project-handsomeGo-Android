package com.hyeong.handsomego.home

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R
import com.hyeong.handsomego.get.GetRankReviewResponseData


/**
 * Created by HYEON on 2018-09-24.
 */
class HomeTabRankAdapter(var rankItems : ArrayList<GetRankReviewResponseData>) : RecyclerView.Adapter<HomeTabRankViewHolder>() {

    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){ //3. 외부에서 넘어온 클릭리스너 설정
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabRankViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false)
        view.setOnClickListener(onItemClick)
        return HomeTabRankViewHolder(view)

    }

    override fun getItemCount(): Int = rankItems.size

    override fun onBindViewHolder(holder: HomeTabRankViewHolder, position: Int) {
        Log.d("123123",holder.place_category.text.toString())
        //역사문화 라는 텍스트가 안들어오는듯..
        if(holder.place_category.text.toString() == "역사 문화"){
            Log.d("123123",holder.place_category.toString())
            holder.place_category.setBackgroundColor(0xfb8b20)
            //holder.place_category.setText("11")
           // holder.place_category.setBackgroundResource(R.drawable.ranking_1)

        } else if (holder.place_category.text.toString() == "도시 건축") {
            holder.place_category.setBackgroundColor(0x5ba2f6)


        }  else if (holder.place_category.text.toString() == "과학 경제") {
            holder.place_category.setBackgroundColor(0x549b0e)
        }

        //textviewbackground
        //자꾸 랭킹 123 오ㅣ에 스크롤할때마다 바뀌어요ㅜㅠㅠㅠ
        holder.placename.text = rankItems[position].place_name
        holder.placerank.text = (position+1).toString()
       if (position.toString() == "0"){
            holder.placerank.setBackgroundResource(R.drawable.ranking_1)
            holder.placerank.setText("")
        }else if (position.toString() == "1"){
            holder.placerank.setBackgroundResource(R.drawable.ranking_2)
           holder.placerank.setText("")
       } else if (position.toString() == "2"){
            holder.placerank.setBackgroundResource(R.drawable.ranking_3)
           holder.placerank.setText("")
       }
    }
}