package rent.my.car.routes

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DaoInMemoryCar as daoCar


fun Route.carRouting() {
    get("/") {
        call.respondText("Rent my car API")
    }

    get("/cars") {
        call.respond(daoCar.allCars())
    }
}
