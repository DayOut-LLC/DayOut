package com.example.dayout

import androidx.fragment.app.Fragment

private const val TAG = "EventFragment"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val EVENT_SEARCH_URL = "https://www.eventbriteapi.com/v3/venues/venue_id/events/?token=${SEARCH_API_KEY}"

class EventFragment : Fragment() {
}