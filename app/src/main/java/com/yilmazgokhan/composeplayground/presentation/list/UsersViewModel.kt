package com.yilmazgokhan.composeplayground.presentation.list

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import com.yilmazgokhan.composeplayground.data.local.list.User
import com.yilmazgokhan.composeplayground.data.mock.basic_list.Users
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasicListViewModel @Inject constructor(
) : BaseViewModel<ListViewState, ListViewEvent>() {

    init {
        LogUtils.d("$this")
        prepareMockUsers()
    }

    override fun createInitialState(): ListViewState = ListViewState()

    override fun onTriggerEvent(event: ListViewEvent) {
        viewModelScope.launch {
            when (event) {
                is ListViewEvent.ListEvent -> {
                    LogUtils.d("$this")
                }
            }
        }
    }

    private fun prepareMockUsers() {
        viewModelScope.launch {
            setState { currentState.copy(isLoading = true) }
            delay(3000)
            setState {
                currentState.copy(
                    users = Users,
                    isLoading = false
                )
            }
        }
    }
}

sealed class ListViewEvent : IViewEvent {
    object ListEvent : ListViewEvent()
}

data class ListViewState(
    val isLoading: Boolean = false,
    var users: List<User> = ArrayList(),
) : IViewState