package got

import org.springframework.boot.test.context.SpringBootTest
import got.service.CharacterService
import got.model.Character
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

@SpringBootTest
class CharacterServiceTest {

    @Autowired
    lateinit var characterService: CharacterService

    lateinit var nedStark : Character

    @BeforeEach
    fun setUp() {
        nedStark = Character().apply {
            name = "Eddard Stark"
            house = "Stark"
        }
    }

    @Test
    fun `save a character in data base`() {
        characterService.saveCharacter(nedStark)
    }
}