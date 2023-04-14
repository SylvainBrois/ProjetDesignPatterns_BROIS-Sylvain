package Singleton

import mvc.HangmanController
import mvc.HangmanModel
import mvc.HangmanView
import strategy.ConsoleInputStrategy
import strategy.InputStrategy

object HangmanGame {
    var inputStrategy: InputStrategy = ConsoleInputStrategy()
    private lateinit var controller: HangmanController
    private val motsPossibles = listOf("PENDU", "ORDINATEUR", "PROGRAMMATION", "KOTLIN")

    /**
     * Renvoie un mot aléatoire provenant de la liste des mots possibles
     */
    fun obtenirMotAleatoire(): String {
        return motsPossibles.random()
    }

    /**
     * Méthode initialisant la partie
     * @param word le mot généré par la méthode obtenirMotAleatoire
     * @param maxAttempts le nombre d'erreurs max autorisées dans la partie
     * @param view le gestionnaire de message
     */
    fun setup(word: String, maxAttempts: Int, view: HangmanView) {
        //initialise la partie
        val model = HangmanModel(word, maxAttempts)
        controller = HangmanController(model, view)
    }

    /**
     * Méthode lançant la partie
     */
    fun start() {
        controller.startGame()
    }

    /**
     * Lecture des entrées de l'utilisateur
     */
    fun readInput(): Char = inputStrategy.getInput()
}
