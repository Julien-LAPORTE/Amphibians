package fr.samneo.amphibians

import fr.samneo.amphibians.data.FakeDataSource
import fr.samneo.amphibians.data.FakeNetworkAmphibiansRepository
import fr.samneo.amphibians.model.AmphibiansListUiState
import fr.samneo.amphibians.rules.TestDispatcherRule
import fr.samneo.amphibians.viewmodel.AmphibiansListUiViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class AmphibiansListUiViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun AmphibiansListUiViewModel_getAmphibians_verifyAmphibiansListUiStateSuccess() = runTest {
        val viewModel = AmphibiansListUiViewModel(
            amphibiansRepository = FakeNetworkAmphibiansRepository()
        )
        assertEquals(viewModel.uiState, AmphibiansListUiState.Success(FakeDataSource.amphibians))
    }
}