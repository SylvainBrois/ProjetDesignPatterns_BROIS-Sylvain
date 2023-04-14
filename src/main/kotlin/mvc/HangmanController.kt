package mvc
class HangmanController(private val model: HangmanModel, private val view: HangmanView) {
    /**
     * Gère l'avancement de la partie et tout le game system.
     * La méthode masque le mot secret en remplacçant toutes les lettres par des "_".
     * À chaque fois qu'une lettre est dévoilée, le jeu la dévoile dans le mot masqué.
     */
    fun startGame() {
        view.showWelcomeMessage()
        while (!model.isGameOver && !model.isWon) {
            val state = model.word.map { if (it in model.guessedLetters) it else '_' }.joinToString(" ")
            view.displayCurrentState(state)
            view.displayRemainingAttempts(model.maxAttempts - model.attempts)
            view.displayHangman(model.maxAttempts - model.attempts)
            val letter = view.askForLetter()
            model.guessLetter(letter)
        }
        if (model.isWon) {
            view.showVictoryMessage()
        } else {
            view.showGameOverMessage()
        }
    }
}
