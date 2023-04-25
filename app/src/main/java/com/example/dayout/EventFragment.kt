package com.example.dayout

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "EventFragment"
private const val SEARCH_API_KEY = BuildConfig.API_KEY
private const val EVENT_SEARCH_URL = "https://www.eventbriteapi.com/v3/venues/venue_id/events/?token=${SEARCH_API_KEY}"

class EventFragment : Fragment() {
    private val events = mutableListOf<Event>()
    private lateinit var eventRV: RecyclerView
    private lateinit var eventAdapter: EventAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Call the new method within onViewCreated
        // fetchEvents()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragmentevent_activity, container, false)

        // Add these configurations for the recyclerView and to configure the adapter
        val layoutManager = LinearLayoutManager(context)
        eventRV = view.findViewById(R.id.event_recycler_view)
        eventRV.layoutManager = layoutManager
        eventRV.setHasFixedSize(true)
        eventAdapter = EventAdapter(view.context, events)
        eventRV.adapter = eventAdapter

        // Update the return statement to return the inflated view from above
        return view
    }

    companion object {
        fun newInstance(): EventFragment {
            return EventFragment()
        }
    }

    /*private fun fetchEvents() {
        val client = AsyncHttpClient()
        client.get(EVENT_SEARCH_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch articles: $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers, json: JSON) {
                Log.i(TAG, "Successfully fetched articles: $json")
                try {
                    val parsedJson = createJson().decodeFromString(
                        SearchNewsResponse.serializer(),
                        json.jsonObject.toString()
                    )
                    parsedJson.response?.docs?.let { list ->
                        events.addAll(list)
                        eventAdapter.notifyDataSetChanged()
                    }
                } catch (e: JSONException) {
                    Log.e(TAG, "Exception: $e")
                }
            }

        })
    }*/
}