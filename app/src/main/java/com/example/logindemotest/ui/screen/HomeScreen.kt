package com.example.logindemotest.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.logindemotest.Utlis.LifeCycleEventObserver
import com.example.logindemotest.ui.commonUi.MyToolbar

@Composable
fun HomeScreen(modifier: Modifier = Modifier.fillMaxSize()) {

    Scaffold(
        topBar = {
            MyToolbar(
                title = "HomeScreen"
            )
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
                .padding(paddingValues)
        ) {

        }

    }
}
private const val TAG = "HomeScreen"