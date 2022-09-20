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
                is LoginViewEvent.EmailChanged -> {
                    LogUtils.d("$this")
                    setState {
                        currentState.copy(
                            email = event.text
                        )
                    }
                }
                is LoginViewEvent.PasswordChanged -> {
                    LogUtils.d("$this")
                    setState {
                        currentState.copy(
                            password = event.text
                        )
                    }
                }
                is LoginViewEvent.RememberMeChanged -> {
                    LogUtils.d("$this")
                    setState {
                        currentState.copy(
                            rememberMe = event.value
                        )
                    }
                }
            }
        }
    }
}

sealed class LoginViewEvent : IViewEvent {
    object LoginEvent : LoginViewEvent()
    class EmailChanged(val text: String) : LoginViewEvent()
    class PasswordChanged(val text: String) : LoginViewEvent()
    class RememberMeChanged(val value: Boolean) : LoginViewEvent()

}

data class LoginViewState(
    val email: String = "",
    val password: String = "",
    val rememberMe: Boolean = false,
    val isLoading: Boolean = false,
) : IViewState