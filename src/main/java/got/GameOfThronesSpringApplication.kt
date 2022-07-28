package got

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class GameOfThronesSpringApplication

fun main(args: Array<String>) {
    runApplication<GameOfThronesSpringApplication>(*args)
}