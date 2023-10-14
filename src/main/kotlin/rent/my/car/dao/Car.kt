package rent.my.car.dao

import rent.my.car.models.Car
import rent.my.car.models.DrivingBehavior
import rent.my.car.models.RentalCar
import rent.my.car.models.TimeBlock

interface CarDAO {
    fun addCar(car: Car)
    fun getCarById(id: Long): Car?
    fun updateCar(car: Car)
    fun deleteCar(id: Long)
    fun getAllCars(): List<Car>
}

interface RentalCarDAO {
    fun addRentalCar(rentalCar: RentalCar)
    fun getRentalCarById(id: Long): RentalCar?
    fun updateRentalCar(rentalCar: RentalCar)
    fun deleteRentalCar(id: Long)
    fun getAllRentalCars(): List<RentalCar>
}

interface TimeBlockDAO {
    fun addTimeBlock(timeBlock: TimeBlock)
    fun getTimeBlockById(id: Long): TimeBlock?
    fun updateTimeBlock(timeBlock: TimeBlock)
    fun deleteTimeBlock(id: Long)
}

interface DrivingBehaviorDAO {
    fun addDrivingBehavior(drivingBehavior: DrivingBehavior)
    fun getDrivingBehaviorById(id: Long): DrivingBehavior?
    fun updateDrivingBehavior(drivingBehavior: DrivingBehavior)
    fun deleteDrivingBehavior(id: Long)
}
