import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/main/resources/day2.txt").inputStream()

    var points = 0
    inputStream.bufferedReader().forEachLine {
        val choice = it.split(" ")
        when(choice[1]) {
            "X" -> points += 1
            "Y" -> points += 2
            "Z" -> points += 3
        }
        println(choice)
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

    println(points)

}