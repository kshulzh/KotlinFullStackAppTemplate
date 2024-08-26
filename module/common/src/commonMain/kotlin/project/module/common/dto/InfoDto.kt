package project.module.common.dto

import kotlinx.serialization.Serializable

@Serializable
data class InfoDto(
    val name: String,
    val data: String
)
