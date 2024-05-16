package fr.samneo.amphibians.data

import fr.samneo.amphibians.model.Amphibian

class FakeNetworkAmphibiansRepository: AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = FakeDataSource.amphibians
}