package com.cha.prueba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cha.prueba.R
import com.cha.prueba.data.network.model.Record

class ItemsAdapter(val itemList: List<Record>): RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {


    class ItemsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val txtTitle      = view.findViewById<TextView>(R.id.tv_title)
        val txtLocation = view.findViewById<TextView>(R.id.tv_location)
        val txtPrice      = view.findViewById<TextView>(R.id.tv_price)
        val imgItem     = view.findViewById<ImageView>(R.id.iv_poster)

        fun initialize( item:  Record) {
            txtTitle.text      = item.productDisplayName
            txtLocation.text = item.seller
            txtPrice.text      = "$" + item.listPrice.toString()

            Glide.with(imgItem.context)
                .load(item.smImage)
                .into(imgItem)
        }

    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int): ItemsAdapter.ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(inflater.inflate(R.layout.rv_items, parent, false))
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ItemsAdapter.ItemsViewHolder, position: Int) {
        holder.initialize(itemList[position])
    }
}