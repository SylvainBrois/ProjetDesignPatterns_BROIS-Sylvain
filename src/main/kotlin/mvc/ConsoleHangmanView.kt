package mvc

import Singleton.HangmanGame

class ConsoleHangmanView : HangmanView {
    override fun showWelcomeMessage() {
        println("Bienvenue dans le jeu du pendu !")
    }

    override fun showGameOverMessage() {
        println("Désolé, vous avez perdu.")
    }

    override fun showVictoryMessage() {
        println("Félicitations, vous avez gagné !")
    }

    override fun displayCurrentState(state: String) {
        println("Mot : $state")
    }

    override fun displayRemainingAttempts(attempts: Int) {
        println("Essais restants : $attempts")
    }

    override fun askForLetter(): Char {
        print("Entrez une lettre : ")
        return HangmanGame.readInput()
    }

    override fun displayHangman(attempts: Int) {
        when (attempts) {
            8 -> println(
                """
                    +---+
                        |
                        |
                        |
                        |
                        |
                =========
                """

            )

            7 -> println(
                """
                    +---+
                    |   |
                        |
                        |
                        |
                        |
                =========
                """
            )

            6 -> println(
                """
                    +---+
                    |   |
                    O   |
                        |
                        |
                        |
                =========
                """
            )

            5 -> println(
                """
                    +---+
                    |   |
                    O   |
                    |   |
                        |
                        |
                =========
                """
            )

            4 -> println(
                """
                    +---+
                    |   |
                    O   |
                   /|   |
                        |
                        |
                =========
                """
            )

            3 -> println(
                """
                    +---+
                    |   |
                    O   |
                   /|\  |
                        |
                        |
                =========
                """
            )

            2 -> println(
                """
                    +---+
                    |   |
                    O   |
                   /|\  |
                   /    |
                        |
                =========
                """
            )

            1 -> println(
                """
                    +---+
                    |   |
                    O   |
                   /|\  |
                   / \  |
                        |
                =========
                """
            )

            else -> println("Pendu complet!")
        }
    }
}
fun main() {
    val word = HangmanGame.obtenirMotAleatoire()
    val maxAttempts = 8
    val view = ConsoleHangmanView()

    HangmanGame.setup(word, maxAttempts, view)
    HangmanGame.start()
}
