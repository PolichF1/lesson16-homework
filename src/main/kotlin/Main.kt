import commands.*
import java.util.*

val allCommands = listOf(
    PrintHelloCommand(),
    HelloFromKirillCommand(),
    TimerCommand(),
    ConvertFahrenheitToCelsiusCommand(),
    ConvertCelsiusToFahrenheitCommand(),
    FizzBuzzCommand(),
    HelloShatokhinCommand(),
    Sibogatov(),
    HelloPyshnikCommand(),
    HelloFromSiarhey(),
    HelloGrebnevCommand(),
    ShowLocalDateTime(),
    Ulasevich()
)

fun main() {
    val scanner = Scanner(System.`in`)

    var isProgramWorking = true

    while (isProgramWorking) {
        print("Enter command: ")
        when (val commandText = scanner.nextLine()) {
            "help" -> {
                allCommands
                    .sortedBy { it.keyword.lowercase(Locale.getDefault()) }
                    .forEach {
                        println("${it.keyword} - ${it.description}")
                    }
            }
            "exit" -> {
                isProgramWorking = false
                println("Bye!")
            }
            else -> {
                val args = commandText.split(" ")
                val commandName = args[0]
                var commandArgument = ""
                if (args.size > 1) {
                    commandArgument = args[1]
                }

                val command = allCommands.find { it.keyword == commandName }

                if (command != null) {
                    command.execute(commandArgument)
                } else {
                    println("unknown command: $commandName")
                }
            }
        }
        println()
    }

}