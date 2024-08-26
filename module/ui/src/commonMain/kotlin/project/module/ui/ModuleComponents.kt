package project.module.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import project.module.common.dto.InfoDto
import project.module.common.service.ModuleService

class ModuleComponents(private val moduleService: ModuleService) {
    @Composable
    fun Info(modifier: Modifier = Modifier, name: String) {
        var info by remember { mutableStateOf<InfoDto?>(null) }
        if (info == null) {
            ActionCircularProgressIndicator(modifier) {
                info = moduleService.getInfo(name)
            }
        } else {
            Info(modifier, info!!)
        }
    }

    @Composable
    fun Info(modifier: Modifier = Modifier, infoDto: InfoDto) {
        Column(modifier) {
            Text(infoDto.name)
            Text(infoDto.data)
        }
    }

    @Composable
    private fun ActionCircularProgressIndicator(modifier: Modifier = Modifier, load: suspend () -> Unit) {
        LaunchedEffect(Unit) {
            load.invoke()
        }
        Box(modifier) {
            CircularProgressIndicator(
                Modifier
                    .align(Alignment.Center)
            )
        }
    }
}