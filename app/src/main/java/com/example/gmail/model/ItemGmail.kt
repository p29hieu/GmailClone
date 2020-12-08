package com.example.gmail.model

import com.google.gson.annotations.SerializedName

class ItemGmail {
    @SerializedName("id")
    val id: String = ""

    @SerializedName("isImportant")
    var isImportant: Boolean = false

    @SerializedName("picture")
    var picture = "https://api.androidhive.info/json/google.png"

    @SerializedName("from")
    var from = ""

    @SerializedName("subject")
    var subject = ""

    @SerializedName("message")
    var message = ""

    @SerializedName("timestamp")
    var timestamp = ""

    @SerializedName("isRead")
    var isRead = false
}