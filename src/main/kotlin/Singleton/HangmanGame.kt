package Singleton

import mvc.HangmanController
import mvc.HangmanModel
import mvc.HangmanView
import strategy.ConsoleInputStrategy
import strategy.InputStrategy

object HangmanGame {
    private val inputStrategy: InputStrategy = ConsoleInputStrategy()
    private lateinit var controller: HangmanController
    private val motsPossibles = listOf("PENDU", "ORDINATEUR", "PROGRAMMATION", "KOTLIN")

    fun obtenirMotAleatoire(): String {
        // Renvoie un mot aléatoire du dictionnaire
        return motsPossibles.random()
    }
    fun setup(word: String, maxAttempts: Int, view: HangmanView) {
        val model = HangmanModel(word, maxAttempts)
        controller = HangmanController(model, view)
    }

    fun start() {
        controller.startGame()
    }

    fun readInput(): Char = inputStrategy.getInput()
}
