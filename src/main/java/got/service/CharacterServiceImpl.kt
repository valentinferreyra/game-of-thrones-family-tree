package got.service

import got.dao.CharacterDAO
import org.springframework.stereotype.Service
import got.model.Character
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
open class CharacterServiceImpl : CharacterService {

    @Autowired
    lateinit var characterDAO : CharacterDAO

    override fun saveCharacter(character: Character): Character {
        return characterDAO.save(character)
    }

    override fun getCharacter(id: Long): Character {
        return characterDAO.findById(id).orElseThrow { RuntimeException("There is not character with that id") }
    }

    override fun allSonsOf(character: Character): List<Character> {
        return characterDAO.allSonsOf(character.id!!)
    }

//    override fun membersOfHouse(house: String): List<Character> {
//        TODO("Not yet implemented")
//    }

    override fun deleteAll() {
        characterDAO.detachDelete()
    }
}