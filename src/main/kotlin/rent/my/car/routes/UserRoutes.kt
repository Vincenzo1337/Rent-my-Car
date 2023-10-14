package rent.my.car.routes

import rent.my.car.dto.UserRegisterDto
import rent.my.car.dto.UserSignInDto
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import rent.my.car.plugins.AlreadyExistsException
import rent.my.car.plugins.WrongSigninException
import rent.my.car.plugins.createJWT
import rent.my.car.dao.DaoInMemoryUser as dao

fun Route.userRouting() {
    authenticate {
        get("/validate") {
            val principal = call.principal<JWTPrincipal>()
            val email = principal?.get("email")
            val userType = principal?.get("userType")
            call.respondText("Hello, $email ($userType) you have validated access!")
        }
    }

    get("/users") {
        call.respond(dao.allUsers())
    }

    // In the example ktor-les-7 we use email as the unique key
    // only the signedin user can retrieve the user profile using the email claim
//    get("/users/{id}") <== removed function from ktor-les6

    post("/signin") {
        val user = call.receive<UserSignInDto>()
        val signedIn = dao.signInUser(user)
        if (signedIn != null) {
            val jwt = createJWT(signedIn.email, signedIn.userType.name)
            call.respond(message = mapOf("token" to jwt))
        } else {
            throw WrongSigninException()
        }
    }

    post("/signup") {
        val user = call.receive<UserRegisterDto>()
        val isRegistered = dao.registerUser(user)
        if (isRegistered) {
            val jwt = createJWT(user.email, user.userType.name)
            call.respond(message = mapOf("token" to jwt))
        } else {
            throw AlreadyExistsException(user.email)
        }
    }

}
