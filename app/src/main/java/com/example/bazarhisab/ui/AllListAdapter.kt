package com.example.bazarhisab.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bazarhisab.R
import com.example.bazarhisab.db.AllList
import kotlinx.android.synthetic.main.all_list_name_on_home_page.view.*

class AllListAdapter(val allList: List<AllList> ) : RecyclerView.Adapter<AllListAdapter.ViewHolder>() {


    class ViewHolder (val view : View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllListAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.all_list_name_on_home_page,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return allList.size
    }

    override fun onBindViewHolder(holder: AllListAdapter.ViewHolder, position: Int) {
        holder.view.list_name_TV.text = allList[position].listName
        holder.view.list_id_TV.text = (position+1).toString()
        holder.view.list_name_TV.setOnClickListener {
            val intent = Intent(it.context,ListDetailsActivity::class.java)
            it.context.startActivity(intent)
        }
    }
}