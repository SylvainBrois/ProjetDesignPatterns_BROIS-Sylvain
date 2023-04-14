import Singleton.HangmanGame
import org.junit.jupiter.api.Test
import kotlin.test.DefaultAsserter.assertEquals
import kotlin.test.assertEquals

class HangmanTests {
    @Test
    fun testVictory() {
        val word = "test"
        val maxAttempts = 5
        val testInputs = listOf('t', 'e', 's')
        HangmanGame.inputStrategy = TestInputStrategy(testInputs)
        val testView = TestHangmanView()
        HangmanGame.setup(word, maxAttempts, testView)
        HangmanGame.start()

        val expectedMessages = listOf(
            "Bienvenue dans le jeu du pendu !",
            "Mot : _ _ _ _",
            "Essais restants : 5",
            "Mot : t _ _ t",
            "Essais restants : 5",
            "Mot : t e _ t",
            "Essais restants : 5",
            "Félicitations, vous avez gagné !"
        )
        assertEquals(expectedMessages, testView.messages)
    }

    @Test
    fun testGameOver() {
        val word = "test"
        val maxAttempts = 3
        val testInputs = listOf('a', 'b', 'c')
        HangmanGame.inputStrategy = TestInputStrategy(testInputs)
        val testView = TestHangmanView()
        HangmanGame.setup(word, maxAttempts, testView)
        HangmanGame.start()

        val expectedMessages = listOf(
            "Bienvenue dans le jeu du pendu !",
            "Mot : _ _ _ _",
            "Essais restants : 3",
            "Mot : _ _ _ _",
            "Essais restants : 2",
            "Mot : _ _ _ _",
            "Essais restants : 1",
            "Désolé, vous avez perdu."
        )
        assertEquals(expectedMessages, testView.messages)
    }

}