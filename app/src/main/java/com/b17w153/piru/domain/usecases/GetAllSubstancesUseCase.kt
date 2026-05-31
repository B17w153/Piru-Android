package com.b17w153.piru.domain.usecases

import com.b17w153.piru.data.repository.SubstanceRepository
import com.b17w153.piru.data.local.entities.SubstanceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllSubstancesUseCase @Inject constructor(
    private val repository: SubstanceRepository
) {
    operator fun invoke(): Flow<List<SubstanceEntity>> {
        return repository.getAllSubstances()
    }
}