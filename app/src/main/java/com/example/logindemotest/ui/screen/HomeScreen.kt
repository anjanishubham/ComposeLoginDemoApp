package com.example.logindemotest.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.logindemotest.Utlis.LifeCycleEventObserver
import com.example.logindemotest.events.UiEvent
import com.example.logindemotest.events.backBottonClicked
import com.example.logindemotest.model.ScreenName
import com.example.logindemotest.ui.commonUi.MyTextView
import com.example.logindemotest.ui.commonUi.MyToolbar

@Composable
fun HomeScreen(modifier: Modifier = Modifier.fillMaxSize(),
               backButtonClickCallBack : (UiEvent) -> Unit) {

    Scaffold(
        topBar = {
            MyToolbar(
                title = "HomeScreen",
                showBackArrow = true
            ){
                Log.d(TAG, "HomeScreen: ")
                backButtonClickCallBack(
                    backBottonClicked(ScreenName.LOGIN_SCREEN)
                )
            }
        }
    ) { paddingValues ->

        val lifecycle = LocalLifecycleOwner.current
        SideEffect {

            // here is lifecycle observer
            LifeCycleEventObserver.lifeCycleEventListener(lifecycle) {
                Log.d(TAG, "Login: $lifecycle")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MyTextView(
                message = "This is home screen",
                textColor = MaterialTheme.colorScheme.tertiary
            )
        }

    }
}
private const val TAG = "HomeScreen"