import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    alias(libs.plugins.compose)
    alias(libs.plugins.kotlin.compose)
}

group = extra["project.group"]!!
version = extra["project.version"]!!

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(libs.bundles.ktor)
    implementation(libs.bundles.ktor.cio)
    implementation(libs.bundles.ktor.content.negotiation)
    implementation(libs.bundles.ktor.serialization.kotlinx.json)
    implementation(libs.bundles.kotlinx.serialization.json)
    implementation(project(":module:common"))
    implementation(project(":module:ui"))
    implementation(project(":module:client"))
}

compose.desktop {
    application {
        mainClass = "project.app.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "desktop"
            packageVersion = "1.0.0"
        }
    }
}
