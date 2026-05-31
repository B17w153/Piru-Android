package com.b17w153.piru.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.b17w153.piru.data.local.entities.SubstanceEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubstanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubstance(substance: SubstanceEntity)

    @Query("SELECT * FROM substances")
    fun getAllSubstances(): Flow<List<SubstanceEntity>>

    @Query("SELECT * FROM substances WHERE id = :id")
    suspend fun getSubstanceById(id: String): SubstanceEntity?

    @Query("DELETE FROM substances WHERE id = :id")
    suspend fun deleteSubstanceById(id: String)
}