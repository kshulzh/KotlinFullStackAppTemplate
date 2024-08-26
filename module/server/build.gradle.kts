plugins {
    alias(libs.plugins.ksp)
    kotlin("jvm")
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    `maven-publish`
}

group = extra["project.group"]!!
version = extra["project.version"]!!


application {
    mainClass.set("project.module.server.MainKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
    api(libs.bundles.koin.core)
    api(libs.bundles.koin.test)
    api(libs.bundles.koin.annotations)
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-config-yaml-jvm")
    implementation("io.ktor:ktor-server-content-negotiation")
    implementation("io.ktor:ktor-serialization-kotlinx-json")
    implementation(libs.bundles.koin.ktor)
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:1.5.6")
    implementation(project(":module:common"))
    implementation(project(":module:core"))
    ksp(libs.bundles.koin.kspCompiler)
}