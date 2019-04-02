package com.example.applaunchertestdrive

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*


class AppDrawerAdapter(val installedApps: List<ApplicationInfo>, val packageManager: PackageManager, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return installedApps.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.row.setOnClickListener{
            val launchIntentForPackage = packageManager.getLaunchIntentForPackage(installedApps[position].packageName)
            context.startActivity(launchIntentForPackage!!)
        }

        val textView = holder.textView
        textView.text = packageManager.getApplicationLabel(installedApps[position])

        val imageView = holder.img
        imageView.setImageDrawable(packageManager.getApplicationIcon(installedApps[position]))

    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var row: ConstraintLayout = itemView.a_row
    var textView: TextView = itemView.txt
    var img: ImageView = itemView.img
}