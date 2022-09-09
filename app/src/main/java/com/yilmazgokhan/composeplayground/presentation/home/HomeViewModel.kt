package com.yilmazgokhan.composeplayground.presentation.home

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel<HomeViewState, HomeViewEvent>() {

    init {
        LogUtils.d("$this")
    }

    override fun createInitialState(): HomeViewState = HomeViewState()

    override fun onTriggerEvent(event: HomeViewEvent) {
        viewModelScope.launch {
            when (event) {
                is HomeViewEvent.HomeEvent -> {
                    LogUtils.d("$this")
                }
            }
        }
    }
}

sealed class HomeViewEvent : IViewEvent {
    object HomeEvent : HomeViewEvent()
}

data class HomeViewState(
    val isLoading: Boolean = false,
) : IViewState