package fr.samneo.amphibians.data

import fr.samneo.amphibians.api.AmphibianApiService
import fr.samneo.amphibians.model.Amphibian

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(
    private val amphibianApiService: AmphibianApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> = amphibianApiService.getAmphibians()
}