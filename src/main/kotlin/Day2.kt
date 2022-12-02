import java.io.File
import java.io.InputStream

fun main() {
    a()
    b()
}

fun a() {
    val inputStream: InputStream = File("src/main/resources/day2.txt").inputStream()
    var points = 0
    inputStream.bufferedReader().forEachLine {
        val choice = it.split(" ")
        when(choice[1]) {
            "X" -> points += 1
            "Y" -> points += 2
            "Z" -> points += 3
        }
        if ((choice[0] == "A" && choice[1] == "Y") || (choice[0] == "B" && choice[1] == "Z") || (choice[0] == "C" && choice[1] == "X")) {
            points += 6
            return@forEachLine
        }
        if ((choice[0] == "A" && choice[1] == "Z") || (choice[0] == "B" && choice[1] == "X") || (choice[0] == "C" && choice[1] == "Y")) {
            points += 0
            return@forEachLine
        }
        points += 3
    }

    println("A: $points")
}

fun b() {
    val inputStream: InputStream = File("src/main/resources/day2.txt").inputStream()
    var points = 0
    inputStream.bufferedReader().forEachLine {
        val choice = it.split(" ")
        when(choice[1]) {
            "X" -> {
                points += 0
                when(choice[0]) {
                    "A" -> points += 3
                    "B" -> points += 1
                    "C" -> points += 2
                }
            }
            "Y" -> {
                points += 3
                when(choice[0]) {
                    "A" -> points += 1
                    "B" -> points += 2
                    "C" -> points += 3
                }
            }
            "Z" -> {
                points += 6
                when(choice[0]) {
                    "A" -> points += 2
                    "B" -> points += 3
                    "C" -> points += 1
                }
            }
        }
    }

    println("B: $points")
}