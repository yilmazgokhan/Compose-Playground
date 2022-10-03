package com.yilmazgokhan.composeplayground.data.local.message

import com.yilmazgokhan.composeplayground.data.local.list.User

data class Message(
    val id: Int,
    val sender: User,
    val receiver: User,
    val content: String,
    val date: Long,
    val isRead: Boolean
)