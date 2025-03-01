package com.example.logindemotest.ui.commonUi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyToolbar(
    title: String,
    showBackArrow: Boolean = false,
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Default.ArrowBack,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = { MyTextView(message = title) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        navigationIcon = {
            if (showBackArrow) {
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = imageVector, // Back Arrow Icon
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.onPrimary // Icon color
                    )
                }
            }
        }
    )

}

