package com.yilmazgokhan.composeplayground.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BasicListView() {

    //region
    val list = listOf(
        ListItem(
            "Gokhan",
            "logicerror",
            "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        ),
        ListItem(
            "James",
            "temp_username",
            "Sed at aliquam libero, viverra."
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
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = item.name,
                    fontWeight = FontWeight.W700
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = " - (${item.username})",
                    color = Color.Gray,
                    fontSize = 14.sp
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
    val summary: String
)