package com.yilmazgokhan.composeplayground.data.local

/**
 * Used in [BasicListScreen]
 */
data class BasicListItem(
    val name: String,
    val username: String,
    val summary: String,
    val imgUrl: String,
    val online: Boolean
)