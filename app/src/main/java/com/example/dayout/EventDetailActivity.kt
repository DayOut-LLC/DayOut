package com.example.dayout

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class EventDetailActivity : AppCompatActivity() {
    private lateinit var eventImage : ImageView
    private lateinit var eventTitle : TextView
    private lateinit var eventStart : TextView
    private lateinit var eventEnd : TextView
    private lateinit var eventDescription : TextView
    private lateinit var eventLocationLabel : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_detail_activity)

        eventImage = findViewById(R.id.event_picture)
        eventTitle = findViewById(R.id.event_titleText)
        eventStart = findViewById(R.id.event_startText)
        eventEnd = findViewById(R.id.event_endText)
        eventDescription = findViewById(R.id.event_descriptionText)
        eventLocationLabel = findViewById(R.id.event_location)

        val event = intent.getSerializableExtra(ARTICLE_EXTRA) as Event

        eventTitle.text = event.eventName?.main
        eventStart.text = event.eventTimeStart?.start
        eventEnd.text = event.eventTimeEnd?.end
        eventDescription.text = event.eventDescription?.original

        Glide.with(this)
            .load(event.mediaImageUrl)
            .into(eventImage)
    }
}