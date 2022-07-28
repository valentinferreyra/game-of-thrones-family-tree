package got.dao

import got.model.Character
import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import org.springframework.data.neo4j.repository.query.Query

@Repository
interface CharacterDAO : Neo4jRepository<Character, Long?> {
    @Query("MATCH (n: Character) DETACH DELETE n")
    fun detachDelete()

    @Query("""
        MATCH (c: Character)-[r:SON]->(s: Character)
        WHERE id(c) = ${'$'}id
        RETURN s
    """)
    fun allSonsOf(id: Long): List<Character>

    @Query("""
        MATCH(c: Character {house : ${'$'}nameOfHouse})
        RETURN c
    """)
    fun allMembersOfHouse(nameOfHouse: String): List<Character>
}