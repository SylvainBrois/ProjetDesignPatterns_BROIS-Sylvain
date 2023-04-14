import Singleton.HangmanGame
import mvc.HangmanView

class TestHangmanView : HangmanView {
    val messages = mutableListOf<String>()

    override fun showWelcomeMessage() {
        messages.add("Bienvenue dans le jeu du pendu !")
    }

    override fun showGameOverMessage() {
        messages.add("Désolé, vous avez perdu.")
    }

    override fun showVictoryMessage() {
        messages.add("Félicitations, vous avez gagné !")
    }

    override fun displayCurrentState(state: String) {
        messages.add("Mot : $state")
    }

    override fun displayRemainingAttempts(attempts: Int) {
        messages.add("Essais restants : $attempts")
    }

    override fun askForLetter(): Char {
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
