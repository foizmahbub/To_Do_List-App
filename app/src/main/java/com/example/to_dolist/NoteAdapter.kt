package com.example.to_dolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.to_dolist.databinding.ItemDesignBinding

class NoteAdapter :ListAdapter<Note,NotViewHolder>(companion){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotViewHolder {
     return NotViewHolder(
         ItemDesignBinding.inflate(LayoutInflater.from(parent.context),
             parent,false)
     )
    }

    override fun onBindViewHolder(holder: NotViewHolder, position: Int) {
       getItem(position).let {
           holder.binding.apply {
           TittleTv.text=it.title
               DateTV.text=it.date
               TimeTV.text=it.time

           }
       }
    }
    companion object{
        val companion=object:DiffUtil.ItemCallback<Note>(){
            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
               return oldItem==newItem
            }

        }
    }
}
