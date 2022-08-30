package com.yilmazgokhan.composeplayground.presentation.message

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.yilmazgokhan.composeplayground.data.local.message.Message
import com.yilmazgokhan.composeplayground.data.mock.message.Messages
import com.yilmazgokhan.composeplayground.ui.component.ButtonDefault
import com.yilmazgokhan.composeplayground.ui.component.TextDefault
import com.yilmazgokhan.composeplayground.ui.component.TextTiny

@Composable
fun MessageScreen() {
    Scaffold(bottomBar = { BottomBar() }) {
        LazyColumn(
            modifier = Modifier
                .padding(horizontal = 4.dp)
                .padding(it)
        ) {
            items(items = Messages) {
                RenderItem(it)
            }
        }
    }
}

@Composable
fun RenderItem(message: Message) {
    Row(
        modifier = Modifier.padding(4.dp),
        verticalAlignment = Alignment.Top
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(message.sender.imgUrl)
                .crossfade(true)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(end = 4.dp)
                .size(48.dp)
                .clip(CircleShape)
        )
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
            ) {
                if (message.sender.username == "logicerror") {
                    TextDefault(text = "You")
                    Text(text = message.content)
                } else {
                    TextDefault(text = message.sender.username)
                    Text(text = message.content)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextTiny(text = TimeAgo.using(message.date))
                }
            }
        }
    }
}

@Composable
fun BottomBar() {
    var text by remember { mutableStateOf(TextFieldValue()) }
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(value = text, onValueChange = { text = it })
        ButtonDefault(text = "SEND")
    }
}