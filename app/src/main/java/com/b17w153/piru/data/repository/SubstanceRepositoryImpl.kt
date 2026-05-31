package com.b17w153.piru.data.repository

import com.b17w153.piru.data.local.dao.SubstanceDao
import com.b17w153.piru.data.local.entities.SubstanceEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SubstanceRepositoryImpl @Inject constructor(
    private val dao: SubstanceDao
) : SubstanceRepository {
    override fun getAllSubstances(): Flow<List<SubstanceEntity>> {
        return dao.getAllSubstances()
    }

    override suspend fun getSubstanceById(id: String): SubstanceEntity? {
        return dao.getSubstanceById(id)
    }

    override suspend fun insertSubstance(substance: SubstanceEntity) {
        dao.insertSubstance(substance)
    }

    override suspend fun deleteSubstanceById(id: String) {
        dao.deleteSubstanceById(id)
    }
}