package rent.my.car

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import rent.my.car.plugins.configureRouting
import rent.my.car.plugins.configureSecurity
import rent.my.car.plugins.configureSerialization

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureSerialization()
    configureSecurity()
    configureRouting()
}
 