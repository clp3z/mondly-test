package com.clp3z.mondlytest.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.clp3z.mondlytest.R
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.presentation.common.MondlyTestScreen

@Composable
fun MainScreen(
    onItemClick: (Item) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {
    viewModel.onViewReady()
    val viewState by viewModel.viewState.collectAsState()

    MondlyTestScreen {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.app_name))
                    },
                    backgroundColor = MaterialTheme.colors.primary
                )
            },
            backgroundColor = MaterialTheme.colors.background
        ) {
            ItemList(
                onItemClick = onItemClick,
                modifier = Modifier.padding(it),
                isLoading = viewState.isLoading,
                items = viewState.items,
                error = viewState.error
            )
        }
    }
}
