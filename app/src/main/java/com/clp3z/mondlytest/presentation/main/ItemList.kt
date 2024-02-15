package com.clp3z.mondlytest.presentation.main

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.clp3z.mondlytest.R
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.presentation.common.ErrorMessage
import com.clp3z.mondlytest.presentation.common.MondlyTestScreen
import com.clp3z.mondlytest.presentation.common.items

@Composable
fun ItemList(
    onItemClick: (Item) -> Unit,
    isLoading: Boolean,
    items: List<Item>,
    error: Error?,
    modifier: Modifier = Modifier
) {
    if (error == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (isLoading) {
                CircularProgressIndicator()
            } else if (items.isNotEmpty()) {
                LazyVerticalGrid(
                    contentPadding = PaddingValues(dimensionResource(id = R.dimen.padding_small)),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                    horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small)),
                    columns = GridCells.Adaptive(dimensionResource(id = R.dimen.cell_min_width)),
                    modifier = modifier
                ) {
                    items(items) { item ->
                        ItemView(
                            item = item,
                            onClick = { onItemClick(item) }
                        )
                    }
                }
            }
        }
    } else {
        ErrorMessage(error)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MediaListPreview() {
    MondlyTestScreen {
        ItemList(
            onItemClick = {},
            isLoading = false,
            items = items,
            error = null
        )
    }
}
