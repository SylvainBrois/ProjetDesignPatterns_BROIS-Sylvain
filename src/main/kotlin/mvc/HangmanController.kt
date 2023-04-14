package mvc
class HangmanController(private val model: HangmanModel, private val view: HangmanView) {
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
