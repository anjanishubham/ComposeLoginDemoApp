package com.example.logindemotest.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.logindemotest.Utlis.LifeCycleEventObserver
import com.example.logindemotest.events.UiEvent
import com.example.logindemotest.events.loginButtonClicked
import com.example.logindemotest.events.passwordChangeListner
import com.example.logindemotest.events.userNameChangeListner
import com.example.logindemotest.model.LoginModel
import com.example.logindemotest.ui.commonUi.MyButton
import com.example.logindemotest.ui.commonUi.MyOutlinedTextField
import com.example.logindemotest.ui.commonUi.MyToolbar
import kotlinx.coroutines.launch

@Composable
fun Login(modifier: Modifier = Modifier.fillMaxSize(),
          state: LoginModel, callback : (UiEvent) -> Unit) {
    val lifecycle = LocalLifecycleOwner.current
    Scaffold(
        topBar = {
            MyToolbar(
                title = "Login"
            )
        }
    ) { paddingValues ->

        SideEffect {
            // here is lifecycle observer
            LifeCycleEventObserver.lifeCycleEventListener(lifecycle){
                Log.d(TAG, "Login: $lifecycle")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            // user name field
            MyOutlinedTextField(
                inputFieldMode = state.userTextFieldModel) { message ->
                Log.d(TAG, "Login: $message")
                callback(userNameChangeListner(message))
            }

            // user password field
            MyOutlinedTextField(
                inputFieldMode = state.passwordTextFieldModel) { message ->
                Log.d(TAG, "Login: $message")
                callback(passwordChangeListner(message))
            }


            MyButton{
                callback(loginButtonClicked)
            }
        }
    }

}

private const val TAG = "LoginScreen"
