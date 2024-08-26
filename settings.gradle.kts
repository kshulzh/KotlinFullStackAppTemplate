pluginManagement {
    repositories {
        mavenLocal()
        google()
        gradlePluginPortal()
        mavenCentral()

        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        maven("https://maven.pkg.jetbrains.space/public/p/kotlinx-html/maven")
        maven("https://maven.google.com")
    }
}
dependencyResolutionManagement {

    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("0.4.0")
}

rootProject.name = "project"
include("module", "module:common", "module:core", "module:client", "module:ui", "module:server")
include("app", "app:desktop")

