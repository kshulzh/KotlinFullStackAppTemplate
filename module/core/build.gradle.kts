plugins {
    alias(libs.plugins.ksp)
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
                api(libs.bundles.koin.core)
                api(libs.bundles.koin.test)
                api(libs.bundles.koin.annotations)
                implementation(project(":module:common"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
            }
        }
        val jvmTest by getting {
            dependencies {
                implementation("org.mockito.kotlin:mockito-kotlin:5.0.0")
            }
        }
    }
}

dependencies {
    ksp(libs.bundles.koin.kspCompiler)
}