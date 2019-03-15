package com.example.applaunchertestdrive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*


class AppDrawerAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val appList = listOf("Gmail")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return appList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.textView
        textView.text = appList[position]
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var row: ConstraintLayout = itemView.a_row
    var textView: TextView = itemView.txt
    var img: ImageView = itemView.img
}