package fr.samneo.amphibians.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import fr.samneo.amphibians.AppApplication
import fr.samneo.amphibians.data.AmphibiansRepository
import fr.samneo.amphibians.model.AmphibiansListUiState
import kotlinx.coroutines.launch
import java.io.IOException


class AmphibiansListUiViewModel(private val amphibiansRepository: AmphibiansRepository) :
    ViewModel() {
    var uiState: AmphibiansListUiState by mutableStateOf(AmphibiansListUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    fun getAmphibians() {
        viewModelScope.launch {
            uiState = try {
                AmphibiansListUiState.Success(amphibiansRepository.getAmphibians())
            } catch (e: IOException) {
                AmphibiansListUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as AppApplication)
                val amphibiansRepository = application.container.amphibiansRepository
                AmphibiansListUiViewModel(amphibiansRepository = amphibiansRepository)
            }
        }
    }

}