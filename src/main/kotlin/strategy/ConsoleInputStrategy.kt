package strategy
class ConsoleInputStrategy : InputStrategy {

    override fun getInput(): Char {
        return readLine()?.firstOrNull()?.uppercaseChar() ?: throw IllegalStateException("Pas d'entrée utilisateur")
    }
}