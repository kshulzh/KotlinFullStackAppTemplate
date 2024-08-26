package project.app

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import project.module.client.http.ModuleServiceClient
import project.module.ui.ModuleComponents

@Composable
@Preview
fun App() {
    val moduleComponents = ModuleComponents(ModuleServiceClient(HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTP
                host = "127.0.0.1"
                port = 8080
            }
        }
    }))
    MaterialTheme {
        moduleComponents.Info(
            modifier = Modifier.fillMaxHeight()
                .fillMaxWidth(), "digits"
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
