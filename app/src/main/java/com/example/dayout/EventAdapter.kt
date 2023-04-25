package com.example.dayout

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "EventAdapter"

class EventAdapter (private val context: Context, private val events: List<Event>) :
    RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.event_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = events.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = events[position]
        holder.bind(event)
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val eventImage = itemView.findViewById<ImageView>(R.id.event_picture)
        private val eventTitle = itemView.findViewById<TextView>(R.id.event_titleText)
        private val eventDescription = itemView.findViewById<TextView>(R.id.event_descriptionText)

        fun bind(event: Event) {
            eventTitle.text = event.eventName?.main
            eventDescription.text = event.eventDescription?.original

            Glide.with(context)
                .load(event.mediaImageUrl)
                .into(eventImage)
        }

        override fun onClick(v: View?) {
            // Get selected article
            val article = events[adapterPosition]

            // Navigate to Details screen and pass selected article
            val intent = Intent(context, EventDetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, article)
            context.startActivity(intent)
        }
    }
}