package com.example.logindemotest.ui.commonUi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyButton(modifier: Modifier = Modifier,
             shape: RoundedCornerShape = RoundedCornerShape(8.dp),
             color: ButtonColors = ButtonDefaults.buttonColors(
                 containerColor = MaterialTheme.colorScheme.primary, // Background color
                 contentColor = MaterialTheme.colorScheme.onPrimary  // Text color
             ),
             onClick: () -> Unit
             ) {

    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        onClick = onClick,
        shape = shape,
        colors = color
    ) {
        Text("Click Me")
      //  MyTextView("click me")
    }

}