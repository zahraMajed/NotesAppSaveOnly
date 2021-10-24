package com.example.notesappsaveonly

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*

class RecyclerAdapter (val notesList: ArrayList<String>):RecyclerView.Adapter<RecyclerAdapter.itemViewHolder>() {
    class itemViewHolder (itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemViewHolder {
       return itemViewHolder(LayoutInflater.from(parent.context).inflate(
           R.layout.item_view,parent,false
       ))
    }

    override fun onBindViewHolder(holder: itemViewHolder, position: Int) {
        val note=notesList[position]
        holder.itemView.apply {
            tvNoteNum.text="Note $position:"
            tvNote.text=note
        }

    }

    override fun getItemCount(): Int = notesList.size

}