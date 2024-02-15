package com.clp3z.mondlytest.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.clp3z.mondlytest.domain.GetItemsUseCase
import com.clp3z.mondlytest.domain.RetrieveItemsUseCase
import com.clp3z.mondlytest.entity.Error
import com.clp3z.mondlytest.entity.Item
import com.clp3z.mondlytest.framework.common.toError
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val retrieveItemsUseCase: RetrieveItemsUseCase
): ViewModel() {

    data class ViewState(
        val isLoading: Boolean = false,
        val items: List<Item> = emptyList(),
        val error: Error? = null
    )

    private val _viewState = MutableStateFlow(ViewState())
    val viewState get() = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            getItemsUseCase()
                .catch { throwable -> _viewState.update { it.copy(error = throwable.toError()) } }
                .collect { items -> _viewState.update { it.copy(items = items) } }
        }
    }

    fun onViewReady() {
        viewModelScope.launch {
            _viewState.update { it.copy(isLoading = true) }
            val error = retrieveItemsUseCase()
            _viewState.update { it.copy(isLoading = false, error = error) }
        }
    }
}
