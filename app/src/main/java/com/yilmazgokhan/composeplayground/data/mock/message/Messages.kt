package com.yilmazgokhan.composeplayground.data.mock.message

import com.yilmazgokhan.composeplayground.data.local.message.Message
import com.yilmazgokhan.composeplayground.data.mock.Texts
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users

val Messages = listOf(
    Message(
        id = 1,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[0],
        date = 111111.0
    ),
    Message(
        id = 2,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[0],
        date = 111111.0
    ),
    Message(
        id = 3,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[0],
        date = 111111.0
    ),
    Message(
        id = 4,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[0],
        date = 111111.0
    ),
)