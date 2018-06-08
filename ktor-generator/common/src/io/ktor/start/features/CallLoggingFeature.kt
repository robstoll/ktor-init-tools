package io.ktor.start.features

import io.ktor.start.*
import io.ktor.start.project.*
import io.ktor.start.util.*

object CallLoggingFeature : Feature(ApplicationKt) {
    override val repos = Repos.ktor
    override val artifacts = listOf("io.ktor:ktor-server-core:\$ktor_version")
    override val id = "call-logging"
    override val title = "CallLogging"
    override val description = "Logs client requests"
    override val documentation = "https://ktor.io/features/call-logging.html"

    override fun BlockBuilder.renderFeature(info: BuildInfo) {
        addImport("io.ktor.features.*")
        addImport("org.slf4j.event.*")
        addFeatureInstall {
            "install(CallLogging)" {
                +"level = Level.INFO"
                +"filter { call -> call.request.path().startsWith(\"/\") }"
            }
        }
    }
}
