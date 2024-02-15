package com.clp3z.mondlytest.presentation.common

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.clp3z.mondlytest.presentation.theme.MondlyTestTheme

@Composable
fun MondlyTestScreen(content: @Composable () -> Unit) {
    MondlyTestTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
