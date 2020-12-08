package com.example.gmail

import android.content.Context
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.model.ItemGmailResponse
import kotlinx.android.synthetic.main.item_gmail.view.*

class GmailAdapter(private var context: Context, private var listItem: List<ItemGmailResponse>) :
    RecyclerView.Adapter<GmailAdapter.MyViewHolder>() {
    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.sender.text = listItem[position].from
        holder.title.text = listItem[position].subject
        holder.content.text = listItem[position].message
        holder.time_send.text = listItem[position].timestamp
        holder.imageAvatar.text = listItem[position].from.substring(0, 1)
        if (listItem[position].isRead) {
            holder.isStarred.setBackgroundResource(R.drawable.ic_baseline_star_24)
            holder.sender.setTypeface(null, Typeface.BOLD)
            holder.title.setTypeface(null, Typeface.BOLD)
            holder.time_send.setTypeface(null, Typeface.BOLD)
        } else {
            holder.isStarred.setBackgroundResource(R.drawable.ic_baseline_star_border_24)
            holder.sender.setTypeface(null, Typeface.NORMAL)
            holder.title.setTypeface(null, Typeface.NORMAL)
            holder.time_send.setTypeface(null, Typeface.NORMAL)
        }
        holder.itemGmail.setOnClickListener {
            Toast.makeText(
                context,
                "${holder.sender.text} onClick",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(layoutInflater.inflate(R.layout.item_gmail, parent, false))
    }

    override fun getItemCount(): Int {
        Log.d("MyTag", "getItemCount ${listItem.size}")
        return listItem.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sender: TextView = view.text_view_sender
        val time_send: TextView = view.time_send
        val title: TextView = view.text_view_title
        var content: TextView = view.text_view_content
        var isStarred: ImageButton = view.image_button_starred
        var imageAvatar: Button = view.image_avatar
        var itemGmail: CardView = view.item_gmail
//        val itemGmail = view.findViewById<LinearLayout>(R.id.item_gmail)

    }
}