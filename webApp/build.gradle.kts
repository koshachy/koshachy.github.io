plugins {
    kotlin("multiplatform") version "2.3.21"
    id("org.jetbrains.compose") version "1.11.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.3.21"
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser {
            binaries.executable()
        }
    }

    sourceSets {
        wasmJsMain {
            dependencies {
                implementation(project(":shared"))
                implementation("org.jetbrains.compose.ui:ui:1.11.0")
                implementation("org.jetbrains.kotlinx:kotlinx-browser:0.5.0")
            }
        }
    }
}