package got.model

import got.model.Character
import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
class Character {
    @Id
    @GeneratedValue
    var id : Long? = null

    @Relationship(type = "SON", direction = Relationship.Direction.OUTGOING)
    var sons: Set<Character>? = null

    @Relationship(type="MARRIED")
    var marriedWith: Character? = null

    @Relationship(type="BROTHER")
    var brotherOf: Set<Character>? = null

    var name : String? = null
    var house : String? = null
}