package fr.samneo.amphibians.model

sealed interface AmphibiansListUiState {
    data class Success(val amphibians: List<Amphibian>) : AmphibiansListUiState
    object Error : AmphibiansListUiState
    object Loading : AmphibiansListUiState
}