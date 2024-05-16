package fr.samneo.amphibians.api

import fr.samneo.amphibians.data.FakeDataSource
import fr.samneo.amphibians.model.Amphibian

class FakeAmphibianApiService : AmphibianApiService {
    override suspend fun getAmphibians(): List<Amphibian> = FakeDataSource.amphibians
}