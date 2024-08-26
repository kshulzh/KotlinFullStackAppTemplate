package project.module.client.http

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import project.module.common.dto.InfoDto
import project.module.common.service.ModuleService

class ModuleServiceClient(private val httpClient: HttpClient) : ModuleService {
    override suspend fun getInfo(name: String): InfoDto {
        return httpClient.get("/info/{name}") {
            parameter("name", name)
        }.body()
    }
}