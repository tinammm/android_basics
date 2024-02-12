package com.example.amphibian.data

import com.example.amphibian.model.Amphibian
import com.example.amphibian.network.AmphibianApiService

interface AmphibianRepository {
    suspend fun getAmphibianDetails(): List<Amphibian>
}

class NetworkAmphibianRepository(
    private val amphibianApiService: AmphibianApiService
): AmphibianRepository {
    override suspend fun getAmphibianDetails(): List<Amphibian> {
        return amphibianApiService.getAmphibians()
    }

}