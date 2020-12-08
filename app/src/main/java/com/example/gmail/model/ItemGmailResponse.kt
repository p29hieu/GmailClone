package com.example.gmail.model

import com.google.gson.annotations.SerializedName

class ItemGmailResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("isImportant") var isImportant: Boolean,
    @SerializedName("picture") var picture: String,
    @SerializedName("from") var from: String,
    @SerializedName("subject") var subject: String,
    @SerializedName("message") var message: String,
    @SerializedName("timestamp") var timestamp: String,
    @SerializedName("isRead") var isRead: Boolean
) {

}