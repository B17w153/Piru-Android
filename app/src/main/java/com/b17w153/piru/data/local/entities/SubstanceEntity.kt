package com.b17w153.piru.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "substances")
data class SubstanceEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val interactionWarnings: List<String>,
    val pharmacokinetics: String, // Placeholder for JSON or serialized data
    val commonDose: String
)