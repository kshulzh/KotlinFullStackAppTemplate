package project.module.server.controller

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import org.koin.ktor.ext.inject
import project.module.common.service.ModuleService

fun Route.educationRoute() {
    val moduleService by inject<ModuleService>()
    route("info") {
        get("{name}") {
            call.respond(moduleService.getInfo(call.parameters["name"] ?: throw NullPointerException()))
        }
    }
}