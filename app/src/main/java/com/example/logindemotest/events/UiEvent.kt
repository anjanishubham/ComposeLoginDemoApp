package com.example.logindemotest.events

sealed interface UiEvent

data object backBottonClicked : UiEvent
data object loginButtonClicked : UiEvent
data class userNameChangeListner(val email:String) : UiEvent
data class passwordChangeListner(val password:String) : UiEvent