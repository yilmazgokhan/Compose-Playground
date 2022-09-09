package com.yilmazgokhan.composeplayground.presentation.login

import androidx.lifecycle.viewModelScope
import com.blankj.utilcode.util.LogUtils
import com.yilmazgokhan.composeplayground.base.BaseViewModel
import com.yilmazgokhan.composeplayground.base.IViewEvent
import com.yilmazgokhan.composeplayground.base.IViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
) : BaseViewModel<LoginViewState, LoginViewEvent>() {

    init {
        LogUtils.d("$this")
    }

    override fun createInitialState(): LoginViewState = LoginViewState()

    override fun onTriggerEvent(event: LoginViewEvent) {
        viewModelScope.launch {
            when (event) {
                is LoginViewEvent.LoginEvent -> {
                    LogUtils.d("$this")
                }
            }
        }
    }
}

sealed class LoginViewEvent : IViewEvent {
    object LoginEvent : LoginViewEvent()
}

data class LoginViewState(
    val userId: Int? = null,
    val isDisplay: Boolean = false,
    val isLoading: Boolean = false,
) : IViewState