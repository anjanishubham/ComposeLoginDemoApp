package com.example.logindemotest.ui.commonUi

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun MyTextView(
    message: String,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = MaterialTheme.typography.titleMedium,
) {

    Text(text = message,
        color = textColor,
        style = textStyle,
    )
}