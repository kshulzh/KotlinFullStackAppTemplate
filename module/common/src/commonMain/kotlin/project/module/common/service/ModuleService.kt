package project.module.common.service

import project.module.common.dto.InfoDto

interface ModuleService {
    suspend fun getInfo(name: String): InfoDto
}