package com.example.newsuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class NewsAdapter(modelList: ArrayList<NewsModel>) : Adapter<NewsAdapter.NewsHolder>() {

    var list = modelList
    class NewsHolder(itemView: View) : ViewHolder(itemView){
        var img = itemView.findViewById<ImageView>(R.id.rcvImg)
        var title = itemView.findViewById<TextView>(R.id.rcvText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        return NewsHolder(LayoutInflater.from(parent.context).inflate(R.layout.news_layout,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        Glide.with(holder.itemView.context).load(list.get(position).img).into(holder.img)
        holder.title.text = list.get(position).title

        holder.itemView.setOnClickListener {

            var intent = Intent(holder.itemView.context,NewsDetailActivity::class.java)
            intent.putExtra("title",list.get(position).title)
            intent.putExtra("img",list.get(position).img)
            intent.putExtra("desc",list.get(position).description)
            holder.itemView.context.startActivity(intent)
        }
    }
}