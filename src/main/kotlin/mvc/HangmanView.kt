package mvc
interface HangmanView {
    fun showWelcomeMessage()
    fun showGameOverMessage()
    fun showVictoryMessage()
    fun displayCurrentState(state: String)
    fun displayRemainingAttempts(attempts: Int)
    fun askForLetter() : Char

    fun displayHangman(attempts : Int)
}
