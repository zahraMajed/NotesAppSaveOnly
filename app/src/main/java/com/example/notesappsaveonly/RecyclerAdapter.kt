package com.example.notesappsaveonly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter (val notesList: ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.itemViewHolder>() {
    class itemViewHolder (itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
       return itemViewHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.item_view,parent,false
       ))
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = notesList.size

}