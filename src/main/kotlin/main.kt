import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val random = Random()

    val options = arrayOf("камень", "ножницы", "бумага")

    var playerChoice: String
    var computerChoice: String

    do {
        println("Выберите: Камень, Ножницы или Бумага (для выхода введите 'выход'): ")
        playerChoice = scanner.next().toLowerCase()

        if (playerChoice == "выход") {
            break
        }

        if (playerChoice != "камень" && playerChoice != "ножницы" && playerChoice != "бумага") {
            println("Неверный выбор. Пожалуйста, выберите Камень, Ножницы или Бумагу.")
            continue
        }

        val randomIndex = random.nextInt(3)
        computerChoice = options[randomIndex]

        println("Вы выбрали: $playerChoice")
        println("Компьютер выбрал: $computerChoice")

        val result = determineWinner(playerChoice, computerChoice)
        if (result == 0) {
            println("Ничья!")
        } else if (result == 1) {
            println("Вы победили!")
        } else {
            println("Компьютер победил!")
        }
    } while (true)

    println("Игра завершена.")
}

fun determineWinner(player: String, computer: String): Int {
    return when {
        (player == "камень" && computer == "ножницы") ||
                (player == "ножницы" && computer == "бумага") ||
                (player == "бумага" && computer == "камень") -> 1
        (computer == "камень" && player == "ножницы") ||
                (computer == "ножницы" && player == "бумага") ||
                (computer == "бумага" && player == "камень") -> -1
        else -> 0
    }
}