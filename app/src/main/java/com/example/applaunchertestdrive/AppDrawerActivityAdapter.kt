package com.example.spudlauncher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.applaunchertestdrive.R
import kotlinx.android.synthetic.main.row.view.*


class AppDrawerAdapter(): RecyclerView.Adapter<ViewHolder>() {
    var appList: ArrayList<String> = ArrayList()

    init {
        appList.add("Google")
    }

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
        textView.setText(appList[position])
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var row: ConstraintLayout
    var textView: TextView
    var img: ImageView

    init {
        row = itemView.a_row
        textView = itemView.txt
        img = itemView.img
    }
}