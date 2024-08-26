package project.module.core.service

import org.koin.core.annotation.Single
import project.module.common.dto.InfoDto
import project.module.common.service.ModuleService
import project.module.core.repository.InfoRepository

@Single
class ModuleServiceImpl(
    private val infoRepository: InfoRepository
) : ModuleService {
    override suspend fun getInfo(name: String): InfoDto {
        return infoRepository.getInfoByName(name).let { InfoDto(it.name, it.data) }
    }
}