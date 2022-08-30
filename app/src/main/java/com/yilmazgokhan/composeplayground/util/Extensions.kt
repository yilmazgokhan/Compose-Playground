package com.yilmazgokhan.composeplayground.util

import com.yilmazgokhan.composeplayground.data.mock.Texts
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users

fun getRandomMessageContent(): String = Texts[(0..Texts.size).random()]

// TODO: edit for duplicate sender or receiver
fun getRandomUser() = Users[(0..Users.size).random()]