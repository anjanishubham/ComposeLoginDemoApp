package com.example.logindemotest.ui.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logindemotest.events.UiEvent
import com.example.logindemotest.events.backBottonClicked
import com.example.logindemotest.events.userNameChangeListner
import com.example.logindemotest.events.loginButtonClicked
import com.example.logindemotest.events.passwordChangeListner
import com.example.logindemotest.model.LoginModel
import com.example.logindemotest.model.initInputFieldModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
    var state by mutableStateOf(LoginModel(
        userTextFieldModel = initInputFieldModel(),
        passwordTextFieldModel = initInputFieldModel(),
        isUserNameValid = false,
        isPasswordValid = false

    ))
        private set

    val loginEvents = MutableSharedFlow<Boolean>()



    fun uiEvent(event: UiEvent) {
        when (event) {
            backBottonClicked -> {}
            loginButtonClicked -> {
                buttonClicked()
            }
            is userNameChangeListner -> {
                userChangeListener(event.email)
            }
            is passwordChangeListner -> {
                passwordChangeListener(event.password)
            }
        }
    }

    private fun buttonClicked() {
        Log.d(TAG, "buttonClicked: ")
        viewModelScope.launch {
            loginEvents.emit(true)
        }
    }

    private fun passwordChangeListener(password: String) {
        state = state.copy(
            passwordTextFieldModel = state.passwordTextFieldModel.copy(
                textValue = password , // Change the property you want to update
                isError = false
                )
        )
    }

    private fun userChangeListener(user: String) {
        state = state.copy(
            userTextFieldModel = state.userTextFieldModel.copy(
                textValue = user,
                isError = false
            )
        )
    }
}

private const val TAG = "LoginViewModel"