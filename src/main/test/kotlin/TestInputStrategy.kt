import strategy.InputStrategy

class TestInputStrategy(private val inputs: List<Char>) : InputStrategy {
    private var currentIndex = 0

    override fun getInput(): Char {
        return if (currentIndex < inputs.size) {
            inputs[currentIndex++]
        } else {
            throw IllegalStateException("Aucune entrée restante dans TestInputStrategy")
        }
    }
}