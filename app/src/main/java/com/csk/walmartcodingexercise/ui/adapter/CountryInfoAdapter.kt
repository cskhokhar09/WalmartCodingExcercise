package com.csk.walmartcodingexercise.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.csk.walmartcodingexercise.R
import com.csk.walmartcodingexercise.model.CountryInfo

class CountryInfoAdapter(private val countryInfoList: List<CountryInfo>): RecyclerView.Adapter<CountryInfoAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(countryInfo: CountryInfo) {
            itemView.findViewById<TextView>(R.id.name).text = String.format(countryInfo.name+",")
            itemView.findViewById<TextView>(R.id.region).text = countryInfo.region
            itemView.findViewById<TextView>(R.id.code).text = countryInfo.code
            itemView.findViewById<TextView>(R.id.capitol).text = countryInfo.capital
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countryInfoList[position])
    }

    override fun getItemCount(): Int = countryInfoList.size
}