package got

import got.helpers.DataService
import got.helpers.ServiceObjects
import org.springframework.boot.test.context.SpringBootTest
import got.service.CharacterService
import org.junit.jupiter.api.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CharacterServiceTest : ServiceObjects() {

    @Autowired lateinit var characterService: CharacterService
    @Autowired lateinit var dataService : DataService

    @BeforeEach
    fun setUp() {
        createObjects()
        dataService.createStartUpDataBase(this)
    }

    @Test
    fun `save a character in data base`() {
        Assertions.assertNotNull(nedStark.id)
    }

    @Test
    fun `get a character from no-relational data base`() {
        val  nedStarkFromDB = characterService.getCharacter(nedStark.id!!)

        Assertions.assertEquals(nedStark.house, nedStarkFromDB.house)
        Assertions.assertEquals(nedStark.name, nedStarkFromDB.name)
        Assertions.assertEquals(nedStark.id, nedStarkFromDB.id)
    }

    @Test
    fun `if try to get a character with an non-existent id, then throws an exception`() {
        dataService.deleteAll()

        Assertions.assertThrows(RuntimeException::class.java) { characterService.getCharacter(1) }
    }

    @Test
    fun `get character's all sons`() {
        val allNedStarkSons = characterService.allSonsOf(nedStark)
        val allDaenerysTargaryenSons = characterService.allSonsOf(daenerysTargaryen)

        Assertions.assertEquals(allNedStarkSons.size, 5)
        Assertions.assertTrue(allDaenerysTargaryenSons.isEmpty())
    }

    @Test
    fun `if try to get all sons of an non existent character, then throws an exception`() {
        dataService.deleteAll()

        Assertions.assertThrows(RuntimeException::class.java) {
            characterService.allSonsOf(nedStark)
        }
    }

    @Test
    fun `get all members of a house`() {
        val allTargaryenMembers = characterService.membersOfHouse("Targaryen")
        val allLannisterMembers = characterService.membersOfHouse("Lannister")

        Assertions.assertEquals(allTargaryenMembers.size, 4)
        Assertions.assertTrue(allLannisterMembers.isEmpty())
    }

    @Test
    fun `if try to get members of a empty String, then throws an exception`() {
        Assertions.assertThrows(RuntimeException::class.java) {
            characterService.membersOfHouse("")
        }
    }

    @AfterEach
    fun tearDown() { dataService.deleteAll() }
}