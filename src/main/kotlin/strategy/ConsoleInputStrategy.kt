package strategy
class ConsoleInputStrategy : InputStrategy {

    /**
     * Stratégie de traitement des entrées de l'utilisateur, tous les caractères entrés seront mis en majuscule,
     * si vide, renverra une erreur.
     * @return le caractère entré par l'utilisateur
     * @throws IllegalStateException si l'utilisateur n'entre pas de caractère
     */
    override fun getInput(): Char {
        return readLine()?.firstOrNull()?.uppercaseChar() ?: throw IllegalStateException("Pas d'entrée utilisateur")
    }
}