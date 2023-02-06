package com.example.wishlistproject2

import android.content.ActivityNotFoundException
import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import android.text.method.LinkMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter (private val items: List<Items>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tv_CR_ItemName)
        val tvPrice = itemView.findViewById<TextView>(R.id.tv_CR_Price)
        val tvStore = itemView.findViewById<TextView>(R.id.tv_CR_Store)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //TODO("Not yet implemented")
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.custom_row_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val item =  items.get(position)
        holder.tvName.text = item.Name
        holder.tvPrice.text = item.Price.toString()
        holder.tvStore.text = item.Store
        holder.tvStore.setOnClickListener{
            try {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.Store))
                ContextCompat.startActivity(it.context, browserIntent, null)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(it.context, "Invalid URL for " + item.Name, Toast.LENGTH_LONG).show()
            }

        }
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return items.size
    }

}