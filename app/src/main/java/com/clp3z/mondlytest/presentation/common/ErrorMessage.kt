package com.clp3z.mondlytest.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.clp3z.mondlytest.R
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.framework.common.toStringMessage

@Composable
fun ErrorMessage(error: Error) {
    val context = LocalContext.current
    val message = error.toStringMessage(context)
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = Icons.Default.Warning,
            contentDescription = message,
            modifier = Modifier.size(86.dp),
            tint = MaterialTheme.colors.error
        )
        Text(
            text = message,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.error,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}

@Preview
@Composable
private fun ErrorMessagePreview() {
    MondlyTestScreen {
        ErrorMessage(error = Error.IO)
    }
}
