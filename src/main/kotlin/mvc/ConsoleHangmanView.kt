package mvc

import Singleton.HangmanGame

class ConsoleHangmanView : HangmanView {
    /**
     * Affiche le message de bienvenue
     */
    override fun showWelcomeMessage() {
        println("Bienvenue dans le jeu du pendu !")
    }

    /**
     * Affiche le message de défaite
     */
    override fun showGameOverMessage() {
        println("Désolé, vous avez perdu.")
    }

    /**
     * Affiche le message de victoire
     */
    override fun showVictoryMessage() {
        println("Félicitations, vous avez gagné !")
    }

    /**
     * Affiche les lettres trouvées par l'utilisateur dans le mot masqué
     * @param state l'état d'avancement dans la trouvaille des lettres du mot masqué
     */
    override fun displayCurrentState(state: String) {
        println("Mot : $state")
    }

    /**
     * Affiche le nombre d'erreurs possibles restantes
     * @param attempts le nombre d'erreurs restantes
     */
    override fun displayRemainingAttempts(attempts: Int) {
        println("Essais restants : $attempts")
    }

    /**
     * Demande à l'utilisateur d'entrer une lettre
     * @return la lettre récupérée dans la console par la stratégie utilisée
     */
    override fun askForLetter(): Char {
        print("Entrez une lettre : ")
        return HangmanGame.readInput()
    }

    /**
     * Affiche l'avancement de la pendaison du prisonnier en fonction du nombre d'erreurs possibles restantes
     * @param attempts le nombre d'erreurs restantes
     */
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
