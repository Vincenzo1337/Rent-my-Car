package rent.my.car.routes

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.dao.DaoInMemoryCar as daoCar


fun Route.carRouting() {
    get("/") {
        call.respondText("Rent my car API")
    }

    get("/cars") {
        if (call.request.queryParameters["search"] != null) {
            call.respond(daoCar.searchCars(call.request.queryParameters["search"]!!))
        } else {
            call.respond(daoCar.allCars())
        }
    }

    get("/car/{id}") {
        val carId = call.parameters["id"]?.toInt()

        if (carId != null) {
            val car = daoCar.getCarById(carId)
            if (car != null) {
                call.respond(car)
            } else {
                call.respondText("Car not found", status = HttpStatusCode.NotFound)
            }
        } else {
            call.respondText("Invalid car ID", status = HttpStatusCode.BadRequest)
        }
    }


}
