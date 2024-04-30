package com.clp3z.mondlytest.presentation.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.clp3z.mondlytest.R
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.presentation.common.MondlyTestScreen
import com.clp3z.mondlytest.presentation.common.item

@Composable
fun ItemView(
    item: Item,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(modifier = modifier.clickable { onClick() }) {
        Column {
            val crossfadeColor = if (isSystemInDarkTheme()) Color.DarkGray else Color.LightGray
            val errorId = if (isSystemInDarkTheme()) R.drawable.error else R.drawable.placeholder
            AsyncImage(
                modifier =
                    Modifier
                        .height(dimensionResource(id = R.dimen.cell_height))
                        .background(crossfadeColor),
                model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(item.image)
                        .crossfade(1500)
                        .build(),
                error = painterResource(id = errorId),
                contentScale = ContentScale.Crop,
                contentDescription = null,
            )
            ItemTitle(item)
        }
    }
}

@Composable
private fun ItemTitle(item: Item) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.secondary)
                .padding(dimensionResource(id = R.dimen.padding_small)),
    ) {
        Text(
            text = item.name,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            fontSize = MaterialTheme.typography.caption.fontSize,
        )
    }
}

@Preview
@Composable
private fun ItemViewPreview() {
    MondlyTestScreen {
        ItemView(
            item = item,
            onClick = {},
        )
    }
}
