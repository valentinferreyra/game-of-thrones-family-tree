package got.dao

import org.springframework.data.neo4j.repository.Neo4jRepository
import org.springframework.stereotype.Repository
import got.model.Character

@Repository
interface CharacterDAO : Neo4jRepository<Character, Long?>