package com.yilmazgokhan.composeplayground.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
    Column(
        modifier = Modifier.padding(2.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = item.name)
        Text(text = item.username)
        Text(text = item.summary)
    }
}


data class ListItem(
    val name: String,
    val username: String,
    val summary: String
)