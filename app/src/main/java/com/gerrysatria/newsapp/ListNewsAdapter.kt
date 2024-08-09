package com.gerrysatria.newsapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gerrysatria.newsapp.databinding.ItemRowNewsBinding

class ListNewsAdapter(private val listNews: ArrayList<News>) : RecyclerView.Adapter<ListNewsAdapter.ListItemHolder>() {

    class ListItemHolder(var binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemHolder {
        val binding = ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemHolder(binding)
    }

    override fun getItemCount(): Int = listNews.size

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) {
        val (title, publishDate, description, photo, source) = listNews[position]

        holder.binding.tvItemTitle.text = title
        holder.binding.tvItemPublishDate.text = publishDate
        holder.binding.tvItemDescription.text = description
        holder.binding.imgPhotoItem.setImageResource(photo)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailNewsActivity::class.java)

            intent.putExtra("title", title)
            intent.putExtra("publishDate", publishDate)
            intent.putExtra("description", description)
            intent.putExtra("photo", photo)
            intent.putExtra("source", source)

            it.context.startActivity(intent)
        }
    }
}