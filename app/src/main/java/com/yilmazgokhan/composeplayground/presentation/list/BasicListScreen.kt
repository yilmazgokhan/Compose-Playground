package com.yilmazgokhan.composeplayground.presentation.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.yilmazgokhan.composeplayground.data.local.BasicListItem
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users
import com.yilmazgokhan.composeplayground.ui.component.InfoBox
import com.yilmazgokhan.composeplayground.ui.component.TextDefault
import com.yilmazgokhan.composeplayground.ui.component.TextSecondary
import com.yilmazgokhan.composeplayground.ui.component.TextTiny

@Composable
fun BasicListView() {

    Scaffold() {
        LazyColumn(modifier = Modifier.padding(horizontal = 4.dp)) {
            items(items = Users) {
                RenderItem(it)
            }
        }
    }
}

@Composable
fun RenderItem(itemBasic: BasicListItem) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        val status: String
        var statusTextColor: Color = Color.Black
        if (itemBasic.online) {
            status = "Online"
            statusTextColor = Color.Green
        } else {
            status = "Offline"
            statusTextColor = Color.Red
        }
        Row(
            modifier = Modifier
                .padding(all = 6.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(itemBasic.imgUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.padding(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextDefault(
                        text = itemBasic.name
                    )
                    InfoBox(
                        text = status,
                        textColor = statusTextColor
                    )
                }
                TextTiny(
                    text = "@${itemBasic.username}",
                )
                Spacer(modifier = Modifier.height(2.dp))
                TextSecondary(
                    text = itemBasic.summary,
                    maxLines = 3
                )
            }
        }
    }
}