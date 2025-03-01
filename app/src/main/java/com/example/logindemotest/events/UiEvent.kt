package com.example.logindemotest.events

import com.example.logindemotest.model.ScreenName

sealed interface UiEvent

data object loginButtonClicked  : UiEvent
data class backBottonClicked(val screenName: ScreenName) : UiEvent
data class userNameChangeListner(val email:String) : UiEvent
data class passwordChangeListner(val password:String) : UiEvent