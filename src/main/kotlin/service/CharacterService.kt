package service

import model.Character

interface CharacterService {
    fun saveCharacter(character: Character) : Character
    fun getCharacter(id: Long) : Character
//    fun allSonsOf(character: Character) : List<Character>
//    fun membersOfHouse(house: String) : List<Character>

//    fun deleteAll()
}