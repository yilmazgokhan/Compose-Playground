package com.yilmazgokhan.composeplayground.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import android.R

@Composable
fun BasicListView() {

    //region
    val list = listOf(
        ListItem(
            "Gokhan",
            "logicerror",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "https://img.freepik.com/free-photo/handsome-confident-smiling-man-with-hands-crossed-chest_176420-18743.jpg?w=2000"
        ),
        ListItem(
            "James",
            "temp_username",
            "Sed at aliquam libero, viverra.",
            "https://www.rollingstone.com/wp-content/uploads/2021/10/B25_37397_RC2_rgbC.jpg?resize=1800,1200&w=450"
        )
    )
    //endregion

    Scaffold(topBar = {

    },
        bottomBar = {

        }) {
        LazyColumn(modifier = Modifier.padding(4.dp)) {
            items(items = list) {
                RenderItem(it)
            }

        }
    }
}

@Composable
fun RenderItem(item: ListItem) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(all = 10.dp)) {
            AsyncImage(
                model = item.imgUrl,
                contentDescription = "",
                modifier = Modifier.size(128.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.imgUrl)
                    .crossfade(true)
                    .build(),
                //placeholder = painterResource(R.drawable.ic_lock_idle_alarm),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = " - (${item.username})",
                    color = Color.Gray,
                    fontSize = 14.sp,
                )
            }
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text = item.summary
            )
        }
    }

}


data class ListItem(
    val name: String,
    val username: String,
    val summary: String,
    val imgUrl: String
)