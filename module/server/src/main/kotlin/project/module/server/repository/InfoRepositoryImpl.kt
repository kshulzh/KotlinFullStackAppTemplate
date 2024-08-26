package project.module.server.repository

import org.koin.core.annotation.Single
import project.module.core.model.Info
import project.module.core.repository.InfoRepository

@Single
class InfoRepositoryImpl : InfoRepository {
    val info = mapOf("digits" to Info("digits", "0,1,2,3,4,5,6,7,8,9"))
    override fun getInfoByName(name: String): Info {
        return info[name] ?: throw NullPointerException()
    }
}