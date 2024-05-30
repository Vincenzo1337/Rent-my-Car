package rent.my.car.dao

import rent.my.car.dto.HomePageCarDTO
import rent.my.car.dto.UserDTO
import rent.my.car.models.*

object DaoInMemoryCar : DAOFacadeCar {

    override suspend fun allCars(): List<HomePageCarDTO> = CarDatabase.cars.map { (id, car) ->
        HomePageCarDTO(
            id = id,
            brand = car.brand,
            type = car.type,
            category = car.category,
            availability = car.availability,
            timeBlock = car.timeBlock,
            description = car.description,
            ownerId = car.ownerId,
            owner = DaoInMemoryUser.getUserById(car.ownerId),
            location = car.location,
            isNew = car.isNew

        )
    }

    override suspend fun searchCars(search: String): List<HomePageCarDTO> =
        CarDatabase.cars.filter { keyValue -> keyValue.value.brand.contains(search) || keyValue.value.type.contains(search) }.map { (id, car) ->
            HomePageCarDTO(
                id = id,
                brand = car.brand,
                type = car.type,
                category = car.category,
                availability = car.availability,
                timeBlock = car.timeBlock,
                description = car.description,
                ownerId = car.ownerId,
                owner = DaoInMemoryUser.getUserById(car.ownerId),
                location = car.location,
                isNew = car.isNew
            )
        }

    fun getCarById(id: Int): HomePageCarDTO? {
        val car = CarDatabase.cars[id]
        if (car != null) {
            return HomePageCarDTO(
                id = id,
                brand = car.brand,
                type = car.type,
                category = car.category,
                availability = car.availability,
                timeBlock = car.timeBlock,
                description = car.description,
                ownerId = car.ownerId,
                owner = DaoInMemoryUser.getUserById(car.ownerId),
                location = car.location,
                isNew = car.isNew
            )
        }
        return null
    }


    override suspend fun createCar(car: Car): Car {
        CarDatabase.cars.put(CarDatabase.cars.size+1,car)
        return car
    }
}

object CarDatabase {
    val cars = mutableMapOf(
        1 to Car(null, "BMW", "E30", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De BMW E30 is een populaire keuze vanwege zijn sportieve uitstraling, betrouwbare prestaties en tijdloze ontwerp.", UserDatabase.users[1]!!.id, null, location = Location(51.560596, 5.091914), isNew = false),
        2 to Car(null, "Volkswagen", "Golf", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Volkswagen Golf is een veelzijdige en populaire keuze vanwege zijn uitstekende reputatie op het gebied van betrouwbaarheid, comfort en efficiëntie. Als een compacte hatchback biedt de Golf voldoende ruimte voor passagiers en bagage, waardoor het een ideale optie is voor zowel stadsritten als langeafstandsreizen.", UserDatabase.users[2]!!.id, null, location = Location(51.9225, 4.4816), isNew = false) ,
        3 to Car(null, "Mercedes", "AMG", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Mercedes-AMG is de belichaming van luxe en prestaties, en het is een gewilde keuze voor autoverhuur vanwege zijn indrukwekkende vermogen, verfijnde interieur en opvallende uitstraling. Met krachtige motoren onder de motorkap en geavanceerde technologieën biedt de Mercedes-AMG een adembenemende rijervaring.", UserDatabase.users[3]!!.id, null, location = Location(51.5876, 4.7750), isNew = false),
        4 to Car(null, "Volvo", "V60", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Volvo V60 is een elegante en veelzijdige keuze, die bekend staat om zijn uitstekende veiligheidsfuncties, comfortabele interieur en moderne Scandinavische design. Als een premium stationwagon biedt de V60 ruime zitplaatsen voor passagiers en een royaal laadruimte, waardoor het ideaal is voor lange reizen, familie-uitjes en avontuurlijke roadtrips.", UserDatabase.users[4]!!.id, null, location = Location(51.6456, 4.8597), isNew = false),
        5 to Car(null, "Toyota", "Corolla", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Toyota Corolla is een betrouwbare en praktische keuze, die bekend staat om zijn duurzaamheid, brandstofefficiëntie en gebruiksgemak. Als een compacte sedan biedt de Corolla comfortabele zitplaatsen voor passagiers en een ruime kofferbak, waardoor het een ideale optie is voor stadsritten, dagelijkse pendelritten en langere reizen.", UserDatabase.users[5]!!.id, null, location = Location(52.0907, 5.1220), isNew = false),
        6 to Car(null, "Ford", "Mustang", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Ford Mustang is een iconische keuze, die bekend staat om zijn krachtige prestaties, kenmerkende ontwerp en nostalgische aantrekkingskracht. Als een legendarische muscle car biedt de Mustang een indrukwekkend vermogen en een opwindende rijervaring die rijplezier garandeert op zowel binnenwegen als snelwegen.", UserDatabase.users[6]!!.id, null, location = Location(52.0894, 4.2808), isNew = false),
        7 to Car(null, "Honda", "Civic", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Honda Civic is een veelzijdige en populaire keuze, die bekend staat om zijn betrouwbaarheid, efficiëntie en comfortabele rijervaring. Als een compacte sedan of hatchback biedt de Civic ruime zitplaatsen voor passagiers en een praktisch interieur, waardoor het ideaal is voor stadsritten, gezinsuitstapjes en lange afstanden.", UserDatabase.users[7]!!.id, null, location = Location(51.5863, 4.7756), isNew = false),
        8 to Car(null, "Nissan", "Altima", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)),  "De Nissan Altima is een comfortabele en praktische keuze, die bekend staat om zijn ruime interieur, soepele rijgedrag en betrouwbare prestaties. Als een middelgrote sedan biedt de Altima ruime zitplaatsen voor passagiers en een royale kofferbak, waardoor het ideaal is voor lange ritten, zakelijke reizen en familie-uitjes. ", UserDatabase.users[8]!!.id, null, location = Location(51.5882, 4.7757), isNew = false),
        9 to Car(null, "Chevrolet", "Silverado", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Chevrolet Silverado is een robuuste en krachtige keuze, die bekend staat om zijn indrukwekkende trekvermogen, ruime cabine en duurzaamheid. Als een full-size pick-up truck biedt de Silverado voldoende ruimte voor passagiers en een ruime laadruimte, waardoor het ideaal is voor avontuurlijke uitstapjes, verhuizingen en werkgerelateerde taken.", UserDatabase.users[9]!!.id, null, location = Location(51.5872, 4.7756), isNew = false),
        10 to Car(null, "Ford", "Fiesta", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Ford Fiesta is een compacte en sportieve auto die bekend staat om zijn wendbaarheid, zuinigheid en betrouwbaarheid. Als een populaire hatchback biedt de Fiesta een comfortabele rit voor zowel bestuurder als passagiers, met een slim ontworpen interieur dat ruimte combineert met functionaliteit. Met zijn levendige rijgedrag en responsieve handling is de Fiesta perfect voor stadsritten en lange afstanden. Bovendien staat de Fiesta bekend om zijn brandstofefficiëntie, ", UserDatabase.users[10]!!.id, null, location = Location(51.8133, 4.6656), isNew = false)
    )
}
