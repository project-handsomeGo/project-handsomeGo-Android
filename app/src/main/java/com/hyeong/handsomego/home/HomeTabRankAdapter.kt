package com.hyeong.handsomego.home

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hyeong.handsomego.R
import com.hyeong.handsomego.get.GetRankReviewResponseData

/**
 * Created by HYEON on 2018-09-24.
 */
class HomeTabRankAdapter(var rankItems : ArrayList<GetRankReviewResponseData>) : RecyclerView.Adapter<HomeTabRankViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeTabRankViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false)
        return HomeTabRankViewHolder(view)
    }

    override fun getItemCount(): Int = rankItems.size

    override fun onBindViewHolder(holder: HomeTabRankViewHolder, position: Int) {

        if(holder.placecategory.text == "역사 문화"){
            holder.placecategory.setBackgroundColor(Color.parseColor("#fb8b20"))
        } else if (holder.placecategory.text == "도시 건축") {
            holder.placecategory.setBackgroundColor(Color.parseColor("#5ba2f6"))
        }  else if (holder.placecategory.text == "과학 경제") {
            holder.placecategory.setBackgroundColor(Color.parseColor("#549b0e"))
        }

        //textviewbackground
        holder.placename.text = rankItems[position].place_name
       holder.placerank.text = (position+1).toString()
        if(position==0){
           holder.placerank.setText(position)
        }
    }
}