package got.dao

import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import got.model.Character
import org.springframework.data.neo4j.repository.query.Query

@Repository
interface CharacterDAO : Neo4jRepository<Character, Long?> {
    @Query("MATCH (n: Character) DETACH DELETE n")
    fun detachDelete()
}