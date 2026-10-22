fun main() {

    println()
    println("Угадай число!")

    do {

        val secretNumber = (0..10).random()

        println("Число от 0 до 10. У вас 3 попытки.")

        var isWin = false

        for (attempt in 1..3) {

            print("Попытка $attempt: ")

            val userGuess = readlnOrNull()?.toIntOrNull()

            if (userGuess == null) {
                println("Введите корректное целое число.")
                continue
            }

            if (userGuess == secretNumber) {

                println("Поздравляем! Вы угадали число $secretNumber!")
                isWin = true
                break

            } else if (userGuess < secretNumber) {
                println("Загаданное число БОЛЬШЕ.")
            } else {
                println("Загаданное число МЕНЬШЕ.")
            }
        }

        if (!isWin) {

            println("Попытки закончились. Вы проиграли!")
            println("Было загадано число: $secretNumber")

        }

    } while (askToRepeat())

    println("Спасибо за игру!")

}

fun askToRepeat(): Boolean {

    while (true) {
        println()
        print("Повторить игру еще раз? 1 - да / 0 - нет: ")
        val choice = readlnOrNull()?.toIntOrNull()
        if (choice == 1) return true
        if (choice == 0) return false
    }
}