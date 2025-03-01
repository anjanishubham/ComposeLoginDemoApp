package com.example.logindemotest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.logindemotest.ui.screen.HomeScreen
import com.example.logindemotest.ui.screen.Login
import com.example.logindemotest.ui.theme.LoginDemoTestTheme
import com.example.logindemotest.ui.viewModel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scop = rememberCoroutineScope()
            var loginState by remember { mutableStateOf(false) }
            LoginDemoTestTheme {
                val viewModel = hiltViewModel<LoginViewModel>()
                val state = viewModel.state
               SideEffect {
                   scop.launch {
                      viewModel.loginEvents.collect{
                          loginEvents ->
                          Log.d(TAG, "onCreate: $loginEvents")
                          loginState = loginEvents

                      }
                   }
               }

                if(loginState){
                    HomeScreen()
                }else{
                    Login(state = state) { uiEvent ->
                        viewModel.uiEvent(uiEvent)
                    }
                }
            }
        }
    }

}

private const val TAG = "MainActivity"
