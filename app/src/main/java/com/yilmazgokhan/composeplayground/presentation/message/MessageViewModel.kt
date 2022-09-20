package com.yilmazgokhan.composeplayground.presentation.message

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import com.yilmazgokhan.composeplayground.data.local.message.Message
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users
import com.yilmazgokhan.composeplayground.data.mock.message.Messages
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
) : BaseViewModel<MessageViewState, MessageViewEvent>() {

    init {
        LogUtils.d("$this")
        prepareMockMessages()
    }

    override fun createInitialState(): MessageViewState = MessageViewState()

    override fun onTriggerEvent(event: MessageViewEvent) {
        viewModelScope.launch {
            when (event) {
                is MessageViewEvent.SendNewMessage -> {
                    LogUtils.d("$this")
                    setState {
                        currentState.copy(
                            hasNewMessage = true,
                            messages = prepareNewMessage(),
                            newMessage = ""
                        )
                    }
                    delay(2000)
                    setState {
                        currentState.copy(
                            hasNewMessage = false
                        )
                    }
                }
                is MessageViewEvent.OnValueChanged -> {
                    LogUtils.d("$this")
                    setState {
                        currentState.copy(
                            newMessage = event.text
                        )
                    }

                }
            }
        }
    }

    private fun prepareMockMessages() {
        viewModelScope.launch {
            setState { currentState.copy(isLoading = true) }
            delay(3000)
            val messages = Messages
            setState {
                currentState.copy(
                    messages = messages,
                    isLoading = false
                )
            }
        }
    }

    private fun prepareNewMessage(): MutableList<Message> {
        val message = Message(
            id = 100,
            sender = Users[0],
            receiver = Users[1],
            content = currentState.newMessage,
            date = System.currentTimeMillis(),
            isRead = false
        )
        val messages = currentState.messages.toMutableList()
        messages.add(message)
        return messages
    }
}

sealed class MessageViewEvent : IViewEvent {
    class OnValueChanged(val text: String) : MessageViewEvent()
    object SendNewMessage : MessageViewEvent()
}

data class MessageViewState(
    val isLoading: Boolean = false,
    val hasNewMessage: Boolean = false,
    val newMessage: String = "",
    var messages: List<Message> = ArrayList(),
) : IViewState