package com.example.logindemotest.model

data class LoginModel(
    val userTextFieldModel: InputFieldModel,
    val passwordTextFieldModel: InputFieldModel,
    val isUserNameValid:Boolean,
    val isPasswordValid:Boolean
)


data class InputFieldModel(
    val paceHolderText:String ="",
    val errorMessageText:String ="",
    val textValue:String ="",
    val isError:Boolean = true
)


fun initInputFieldModel(
    paceHolderText: String = "Enter value in here ..",
    errorMessageText: String = "Invalid value",
    textValue: String = ""
): InputFieldModel {
    return InputFieldModel(
        paceHolderText = paceHolderText,
        errorMessageText = errorMessageText,
        textValue = textValue
    )
}