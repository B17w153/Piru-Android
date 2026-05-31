package com.b17w153.piru.data.repository

import com.b17w153.piru.data.local.entities.SubstanceEntity
import kotlinx.coroutines.flow.Flow

interface SubstanceRepository {
    fun getAllSubstances(): Flow<List<SubstanceEntity>>
    suspend fun getSubstanceById(id: String): SubstanceEntity?
    suspend fun insertSubstance(substance: SubstanceEntity)
    suspend fun deleteSubstanceById(id: String)
}