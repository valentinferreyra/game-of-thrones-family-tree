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

        Assertions.assertEquals(allNedStarkSons.size, 5)
    }

    @AfterEach
    fun tearDown() { dataService.deleteAll() }
}