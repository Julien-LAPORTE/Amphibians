package fr.samneo.amphibians

import androidx.lifecycle.viewmodel.compose.viewModel
import fr.samneo.amphibians.api.FakeAmphibianApiService
import fr.samneo.amphibians.data.FakeDataSource
import fr.samneo.amphibians.data.FakeNetworkAmphibiansRepository
import fr.samneo.amphibians.data.NetworkAmphibiansRepository
import fr.samneo.amphibians.model.AmphibiansListUiState
import fr.samneo.amphibians.viewmodel.AmphibiansListUiViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansRepositoryTest {

    @Test
    fun amphibiansRepository_getAmphibians_verifyAmphibianList() = runTest {
        val repository = NetworkAmphibiansRepository(
            amphibianApiService = FakeAmphibianApiService()
        )
        assertEquals(repository.getAmphibians(), FakeDataSource.amphibians)
    }

    @Test
    fun amphibiansListUiViewModel_getAmphibians_verifyAmphibianList() = runTest {
    }
}