package got.helpers

import got.model.Character

open class ServiceObjects {

    lateinit var nedStark : Character
    lateinit var aryaStark : Character
    lateinit var sansaStark : Character
    lateinit var branStark : Character
    lateinit var rickonStark : Character
    lateinit var robStark : Character
    lateinit var viserysTargaryen : Character
    lateinit var daenerysTargaryen : Character
    lateinit var catellynTully : Character
    lateinit var lyannaStark : Character
    lateinit var rhaegarTargaryen : Character
    lateinit var jonSnow : Character

    fun createObjects() {
        sansaStark = Character().apply {
            name = "Sansa Stark"
            house = "Stark"
        }
        aryaStark = Character().apply {
            name = "Arya Stark"
            house = "Stark"
        }
        branStark = Character().apply {
            name = "Bran Stark"
            house = "Stark"
        }
        rickonStark = Character().apply {
            name = "Rickon Stark"
            house = "Stark"
        }
        robStark = Character().apply {
            name = "Robb Stark"
            house = "Stark"
        }
        jonSnow = Character().apply {
            name = "Jon Snow"
            house = "Targaryen"
        }
        viserysTargaryen = Character().apply {
            name = "Viserys Targaryen"
            house = "Targaryen"
        }
        daenerysTargaryen = Character().apply {
            name = "Daenerys Targaryen"
            house = "Targaryen"
        }
        rhaegarTargaryen = Character().apply {
            name = "Rhaegar Targaryen"
            house = "Targaryen"
            sons = setOf(jonSnow)
            brotherOf = setOf(viserysTargaryen, daenerysTargaryen)
        }
        catellynTully = Character().apply {
            name = "Catellyn Tully"
            house = "Tully"
        }
        lyannaStark = Character().apply {
            name = "Lyanna Stark"
            house = "Stark"
            sons = setOf(jonSnow)
            marriedWith = rhaegarTargaryen
        }
        nedStark = Character().apply {
            name = "Ned Stark"
            house = "Stark"
            sons = setOf(sansaStark, branStark, aryaStark, rickonStark, robStark)
            marriedWith = catellynTully
            brotherOf = setOf(lyannaStark)
        }
    }
}