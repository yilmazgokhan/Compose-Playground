package com.yilmazgokhan.composeplayground.data.local.message

import com.yilmazgokhan.composeplayground.data.local.list.User

data class Message(
    val id: Int? = null,
    val sender: User? = null,
    val receiver: User? = null,
    val content: String? = null,
    val date: Double? = null,
)