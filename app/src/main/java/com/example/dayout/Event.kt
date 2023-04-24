package com.example.dayout

import androidx.annotation.Keep
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Keep
@Serializable
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Event>?
)

@Keep
@Serializable
data class Event(
    @SerialName("web_url")
    val webUrl: String?,
    @SerialName("name")
    val eventName: Name?,
    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,
    @SerialName("description")
    val eventDescription: Description?,
    @SerialName("start")
    val eventTimeStart: Start?,
    @SerialName("end")
    val eventTimeEnd: End?,
) : java.io.Serializable {
    val mediaImageUrl =
        "https://www.eventbrite.com/e/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

@Keep
@Serializable
data class Name(
    @SerialName("text")
    val main: String
) : java.io.Serializable

@Keep
@Serializable
data class Description(
    @SerialName("text")
    val original: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class Start(
    @SerialName("local")
    val start: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class End(
    @SerialName("local")
    val end: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable