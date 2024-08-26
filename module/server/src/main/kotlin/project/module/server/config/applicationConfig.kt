package project.module.server.config

import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing
import org.koin.ksp.generated.module
import org.koin.ktor.plugin.Koin
import project.module.core.ModuleModule
import project.module.server.ModuleServerModule
import project.module.server.controller.educationRoute

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }
    install(Koin) {
        modules(
            ModuleModule().module,
            ModuleServerModule().module
        )
    }
    routing {
        educationRoute()
    }
}