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
            owner = DaoInMemoryUser.getUserById(car.ownerId)
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
                owner = DaoInMemoryUser.getUserById(car.ownerId)
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
                owner = DaoInMemoryUser.getUserById(car.ownerId)
            )
        }
        return null
    }
}

object CarDatabase {
    val cars = mutableMapOf(
        1 to Car("BMW", "E30", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De BMW E30 is een populaire keuze vanwege zijn sportieve uitstraling, betrouwbare prestaties en tijdloze ontwerp. Of het nu gaat om een dagje uit, een weekendtrip of zelfs een speciale gelegenheid, de E30 trekt vaak de aandacht van huurders die op zoek zijn naar een unieke rijervaring.", UserDatabase.users[1]!!.id),
        2 to Car("Volkswagen", "Golf", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Volkswagen Golf is een veelzijdige en populaire keuze vanwege zijn uitstekende reputatie op het gebied van betrouwbaarheid, comfort en efficiëntie. Als een compacte hatchback biedt de Golf voldoende ruimte voor passagiers en bagage, waardoor het een ideale optie is voor zowel stadsritten als langeafstandsreizen.", UserDatabase.users[2]!!.id),
        3 to Car("Mercedes", "AMG", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Mercedes-AMG is de belichaming van luxe en prestaties, en het is een gewilde keuze voor autoverhuur vanwege zijn indrukwekkende vermogen, verfijnde interieur en opvallende uitstraling. Met krachtige motoren onder de motorkap en geavanceerde technologieën biedt de Mercedes-AMG een adembenemende rijervaring.", UserDatabase.users[3]!!.id),
        4 to Car("Volvo", "V60", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Volvo V60 is een elegante en veelzijdige keuze, die bekend staat om zijn uitstekende veiligheidsfuncties, comfortabele interieur en moderne Scandinavische design. Als een premium stationwagon biedt de V60 ruime zitplaatsen voor passagiers en een royaal laadruimte, waardoor het ideaal is voor lange reizen, familie-uitjes en avontuurlijke roadtrips.", UserDatabase.users[4]!!.id),
        5 to Car("Toyota", "Corolla", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Toyota Corolla is een betrouwbare en praktische keuze, die bekend staat om zijn duurzaamheid, brandstofefficiëntie en gebruiksgemak. Als een compacte sedan biedt de Corolla comfortabele zitplaatsen voor passagiers en een ruime kofferbak, waardoor het een ideale optie is voor stadsritten, dagelijkse pendelritten en langere reizen.", UserDatabase.users[5]!!.id),
        6 to Car("Ford", "Mustang", CarCategory.BEV, false, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Ford Mustang is een iconische keuze, die bekend staat om zijn krachtige prestaties, kenmerkende ontwerp en nostalgische aantrekkingskracht. Als een legendarische muscle car biedt de Mustang een indrukwekkend vermogen en een opwindende rijervaring die rijplezier garandeert op zowel binnenwegen als snelwegen.", UserDatabase.users[6]!!.id),
        7 to Car("Honda", "Civic", CarCategory.FCEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Honda Civic is een veelzijdige en populaire keuze, die bekend staat om zijn betrouwbaarheid, efficiëntie en comfortabele rijervaring. Als een compacte sedan of hatchback biedt de Civic ruime zitplaatsen voor passagiers en een praktisch interieur, waardoor het ideaal is voor stadsritten, gezinsuitstapjes en lange afstanden.", UserDatabase.users[7]!!.id),
        8 to Car("Nissan", "Altima", CarCategory.BEV, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)),  "De Nissan Altima is een comfortabele en praktische keuze, die bekend staat om zijn ruime interieur, soepele rijgedrag en betrouwbare prestaties. Als een middelgrote sedan biedt de Altima ruime zitplaatsen voor passagiers en een royale kofferbak, waardoor het ideaal is voor lange ritten, zakelijke reizen en familie-uitjes. ", UserDatabase.users[8]!!.id),
        9 to Car("Chevrolet", "Silverado", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Chevrolet Silverado is een robuuste en krachtige keuze, die bekend staat om zijn indrukwekkende trekvermogen, ruime cabine en duurzaamheid. Als een full-size pick-up truck biedt de Silverado voldoende ruimte voor passagiers en een ruime laadruimte, waardoor het ideaal is voor avontuurlijke uitstapjes, verhuizingen en werkgerelateerde taken.", UserDatabase.users[9]!!.id),
        10 to Car("Ford", "Fiesta", CarCategory.ICE, true, listOf(TimeBlock(startTime = 1000, endTime = 1000)), "De Ford Fiesta is een compacte en sportieve auto die bekend staat om zijn wendbaarheid, zuinigheid en betrouwbaarheid. Als een populaire hatchback biedt de Fiesta een comfortabele rit voor zowel bestuurder als passagiers, met een slim ontworpen interieur dat ruimte combineert met functionaliteit. Met zijn levendige rijgedrag en responsieve handling is de Fiesta perfect voor stadsritten en lange afstanden. Bovendien staat de Fiesta bekend om zijn brandstofefficiëntie, ", UserDatabase.users[10]!!.id)
    )
}
