package rent.my.car.dao

import rent.my.car.dao.Reserveringen
//import rent.my.car.dao.ReserveringenDatabase.reserveringen
import rent.my.car.dto.CarDTO
import rent.my.car.dto.ReserveringenDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.*


object DAOInMemoryReserveringen : DAOFacadeReserveringen {

    override suspend fun allReserveringen(): List<ReserveringenDTO> = reserveringen.values.map{ reserveringen ->
        ReserveringenDTO(
            userid = reserveringen.userid,
            car = reserveringen.car,
            timeBlock = reserveringen.timeBlock,
            price = reserveringen.price,
        )
    }}

private data class Reserveringen(
    val userid: Int,
    val car: String,
    val price: Int,
)

private val reserveringen = mutableMapOf(
    1 to Reserveringen(0,"volvo", ReserveringenCategory.MONDAY, price = 4),
    2 to Reserveringen(1, "Golf", ReserveringenCategory.FRIDAY, price = 7),
    3 to Reserveringen(3,"Merrie", ReserveringenCategory.WEDNESDAY, price = 6),
)
//object ReserveringenDatabase{
//    val reserveringen: MutableList<Reserveringen> = mutableListOf(
//        Reserveringen(1, "Volvo", timeBlock = ReserveringenCategory.WEDNESDAY, price = 3),
//    )
//}
