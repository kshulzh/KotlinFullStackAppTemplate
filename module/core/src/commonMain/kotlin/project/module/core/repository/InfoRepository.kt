package project.module.core.repository

import project.module.core.model.Info

interface InfoRepository {
    fun getInfoByName(name: String): Info
}