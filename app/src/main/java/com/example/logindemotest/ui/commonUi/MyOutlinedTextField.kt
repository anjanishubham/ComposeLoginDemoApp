package com.example.logindemotest.ui.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.logindemotest.model.InputFieldModel


@Composable
fun MyOutlinedTextField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    inputFieldMode : InputFieldModel,
    onTextChange : (String) -> Unit,
) {

    var typeMessage by remember { mutableStateOf(inputFieldMode.textValue) }

    OutlinedTextField(
        label = {
            Text(text = inputFieldMode.paceHolderText)
        },
        modifier = modifier
            .padding(8.dp),
        value = typeMessage,
        onValueChange = {
            typeMessage = it
            onTextChange(typeMessage)
        },
        isError = inputFieldMode.isError,
        keyboardActions = KeyboardActions(
            onDone = {
                onTextChange(typeMessage)
            }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done
        ),
        trailingIcon = {
        }
    )

}
