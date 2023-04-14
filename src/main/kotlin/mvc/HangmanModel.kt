package mvc

data class HangmanModel(val word: String, val maxAttempts: Int) {
    val guessedLetters = mutableSetOf<Char>()
    var attempts = 0
    var isGameOver = false
    var isWon = false
        get() = field && !isGameOver

    fun guessLetter(letter: Char): Boolean {
        if (isGameOver) return false
        guessedLetters.add(letter)
        if(letter !in word){
            attempts ++
        }
        isGameOver = attempts >= maxAttempts
        isWon = word.all { it in guessedLetters }
        return letter in word
    }
}

