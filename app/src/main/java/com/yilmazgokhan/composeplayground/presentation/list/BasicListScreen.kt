package com.yilmazgokhan.composeplayground.presentation.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.yilmazgokhan.composeplayground.data.local.list.User
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users
import com.yilmazgokhan.composeplayground.ui.component.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BasicListView(
    viewModel: BasicListViewModel,
    navigateToBack: () -> Unit,
    navigateToDetail: (User) -> Unit
) {
    val viewState by viewModel.uiState.collectAsState()

    Scaffold {
        LazyColumn(modifier = Modifier.padding(horizontal = 4.dp)) {
            items(items = Users) {
                RenderItem(it)
            }
        }
    }
}

@Composable
fun RenderItem(user: User) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        val status: String
        var statusTextColor: Color = Color.Black
        if (user.online) {
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
            /*
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(user.imgUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
             */
            Column(modifier = Modifier.padding(4.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TextDefault(
                        text = user.name
                    )
                    InfoBox(
                        text = status,
                        textColor = statusTextColor
                    )
                }
                TextTiny(
                    text = "@${user.username}",
                )
                Spacer(modifier = Modifier.height(2.dp))
                TextSecondary(
                    text = user.summary,
                    maxLines = 3
                )
            }
        }
    }
}