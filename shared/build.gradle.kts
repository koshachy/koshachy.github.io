plugins {
    kotlin("multiplatform") version "2.3.21"
    id("org.jetbrains.compose") version "1.11.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.3.21"
}

kotlin {
    @OptIn(org.jetbrains.kotlin.gradle.ExperimentalWasmDsl::class)
    wasmJs {
        browser()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.compose.runtime:runtime:1.11.0")
                implementation("org.jetbrains.compose.foundation:foundation:1.11.0")
                implementation("org.jetbrains.compose.material3:material3:1.11.0-alpha07")
                implementation("org.jetbrains.compose.components:components-resources:1.11.0")

                implementation("io.coil-kt.coil3:coil-compose:3.5.0-beta01")
                implementation("io.coil-kt.coil3:coil-network-ktor3:3.5.0-beta01")
            }
        }
    }
}