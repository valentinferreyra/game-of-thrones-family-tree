package got.model

import org.springframework.data.neo4j.core.schema.GeneratedValue
import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
class Character {
    @Id
    @GeneratedValue
    var id : Long? = null

    var name : String? = null
    var house : String? = null
}