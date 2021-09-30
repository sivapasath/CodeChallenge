package com.tcs.codechalllenge.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tcs.codechalllenge.R
import com.tcs.codechalllenge.model.SearchSubListResponse

class SearchListAdapter() : RecyclerView.Adapter<SearchListAdapter.ViewHolder>() {

    private var searchSubList: List<SearchSubListResponse> = arrayListOf()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = searchSubList[position].lf
    }

    override fun getItemCount(): Int {
        return searchSubList.size
    }

    fun addList(it: List<SearchSubListResponse>?) {
        if (it != null) {
            searchSubList = it
            notifyDataSetChanged()
        };
    }
}