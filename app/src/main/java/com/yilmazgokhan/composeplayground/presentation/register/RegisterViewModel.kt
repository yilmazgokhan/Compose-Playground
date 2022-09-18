package com.yilmazgokhan.composeplayground.presentation.register

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
) : BaseViewModel<RegisterViewState, RegisterViewEvent>() {

    init {
        LogUtils.d("$this")
    }

    override fun createInitialState(): RegisterViewState = RegisterViewState()

    override fun onTriggerEvent(event: RegisterViewEvent) {
        viewModelScope.launch {
            when (event) {
                is RegisterViewEvent.RegisterEvent -> {
                    LogUtils.d("$this")
                }
            }
        }
    }
}

sealed class RegisterViewEvent : IViewEvent {
    object RegisterEvent : RegisterViewEvent()
}

data class RegisterViewState(
    val userId: Int? = null,
    val isDisplay: Boolean = false,
    val isLoading: Boolean = false,
) : IViewState