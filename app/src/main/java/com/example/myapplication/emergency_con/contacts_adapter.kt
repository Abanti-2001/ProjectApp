package com.example.myapplication.emergency_con

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class contacts_adapter(private val contact: List<contacts>
                    ,private val onItemClicked: (position: Int) -> Unit )
                    : RecyclerView.Adapter<contacts_adapter.ViewHolder>(){

     class ViewHolder(view: View,
                      private val onItemClicked: (position: Int) -> Unit)
                    : RecyclerView.ViewHolder(view),View.OnClickListener {
         var name : TextView = view.findViewById(R.id.person_name)
         var number : TextView = view.findViewById(R.id.phone)
         init {
             view.setOnClickListener(this)
         }
         override fun onClick(v: View?) {
             val position = adapterPosition
             onItemClicked(position)
         }
     }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.contact_item, viewGroup, false)
        return ViewHolder(view,onItemClicked)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text= contact[position].name
        holder.number.text= contact[position].number.toString()

    }

    override fun getItemCount(): Int {
        return contact.size
    }


}