package com.yilmazgokhan.composeplayground.presentation.message

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.github.marlonlom.utilities.timeago.TimeAgo
import com.yilmazgokhan.composeplayground.data.local.message.Message
import com.yilmazgokhan.composeplayground.ui.component.*
import com.yilmazgokhan.composeplayground.ui.theme.Purple200

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MessageScreen(
    viewModel: MessageViewModel,
    navigateToBack: () -> Unit,
) {
    val viewState by viewModel.uiState.collectAsState()

    DefaultScaffold(
        topBar = {
            DefaultToolbar(
                title = "Messsages",
                onBackPressClick = navigateToBack
            )
        },
        bottomBar = { NewMessageView(viewState, viewModel) },
        content = {
            LazyColumn(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .padding(it)
            ) {
                items(items = viewState.messages) {
                    RenderItem(it)
                }
            }
            NewMessageAlertView(state = viewState)
        }, loading = viewState.isLoading
    )
}

@Composable
fun RenderItem(message: Message) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth(),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(6.dp)
        ) {
            Row {
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
                Column {
                    TextDefault(text = message.sender.name)
                    TextSecondary(text = message.sender.username)
                }
            }
            Column(
                modifier = Modifier
                    .padding(6.dp)
                //.fillMaxWidth()
            ) {
                Text(text = message.content)
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
fun NewMessageAlertView(state: MessageViewState) {
    if (state.hasNewMessage) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Transparent)
                .padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Purple200)
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    text = "There is new message",
                    fontSize = 14.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun NewMessageView(state: MessageViewState, viewModel: MessageViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = state.newMessage,
            onValueChange = { viewModel.onTriggerEvent(MessageViewEvent.OnValueChanged(it)) }
        )
        ButtonDefault(
            text = "SEND",
            click = { viewModel.onTriggerEvent(MessageViewEvent.SendNewMessage) })
    }
}