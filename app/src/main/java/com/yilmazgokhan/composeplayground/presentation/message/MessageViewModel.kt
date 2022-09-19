package com.yilmazgokhan.composeplayground.presentation.message

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject constructor(
) : BaseViewModel<MessageViewState, MessageViewEvent>() {

    init {
        LogUtils.d("$this")
    }

    override fun createInitialState(): MessageViewState = MessageViewState()

    override fun onTriggerEvent(event: MessageViewEvent) {
        viewModelScope.launch {
            when (event) {
                is MessageViewEvent.HomeEvent -> {
                    LogUtils.d("$this")
                }
            }
        }
    }
}

sealed class MessageViewEvent : IViewEvent {
    object HomeEvent : MessageViewEvent()
}

data class MessageViewState(
    val isLoading: Boolean = false,
) : IViewState