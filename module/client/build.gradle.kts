plugins {
    alias(libs.plugins.kotlin.multiplatform)
    `maven-publish`
}

group = extra["project.group"]!!
version = extra["project.version"]!!

kotlin {
    jvm {
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.bundles.ktor)
                implementation(project(":module:common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}