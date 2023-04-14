package mvc

data class HangmanModel(val word: String, val maxAttempts: Int) {
    val guessedLetters = mutableSetOf<Char>()
    var attempts = 0
    var isGameOver = false
    var isWon = false
        get() = field && !isGameOver

    /**
     * Détermine si la lettre proposée par l'utilisateur est dans le mot ou non
     * @param letter la lettre à vérifier
     * @return true ou false selon si la lettre est présente ou non. Si la lettre n'est pas présente, le compteur d'erreur incrémente
     */
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

