package com.yilmazgokhan.composeplayground.data.mock.message

import com.yilmazgokhan.composeplayground.data.local.message.Message
import com.yilmazgokhan.composeplayground.data.mock.Texts
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users

var Messages = mutableListOf(
    Message(
        id = 1,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[0],
        date = 1651847785595,
        isRead = true,
    ),
    Message(
        id = 2,
        sender = Users[1],
        receiver = Users[0],
        content = Texts[1],
        date = 1656847785595,
        isRead = false,
    ),
    Message(
        id = 3,
        sender = Users[2],
        receiver = Users[1],
        content = Texts[3],
        date = 1656849785595,
        isRead = false,
    ),
    Message(
        id = 4,
        sender = Users[2],
        receiver = Users[1],
        content = Texts[2],
        date = 1657149785595,
        isRead = false,
    ),
    Message(
        id = 5,
        sender = Users[1],
        receiver = Users[0],
        content = Texts[4],
        date = 1657949785595,
        isRead = false,
    ),
    Message(
        id = 6,
        sender = Users[3],
        receiver = Users[1],
        content = Texts[5],
        date = 1667949785595,
        isRead = false,
    ),
    Message(
        id = 6,
        sender = Users[0],
        receiver = Users[1],
        content = Texts[5],
        date = 1667949785595,
        isRead = false,
    ),
    Message(
        id = 6,
        sender = Users[4],
        receiver = Users[1],
        content = Texts[5],
        date = 1667949785595,
        isRead = false,
    ),
)