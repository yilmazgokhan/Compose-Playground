package com.yilmazgokhan.composeplayground.data.local.list

/**
 * Used in [BasicListScreen]
 */
data class User(
    val name: String,
    val username: String,
    val summary: String,
    val imgUrl: String,
    val online: Boolean
)