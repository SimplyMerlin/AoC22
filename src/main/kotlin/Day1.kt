import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("src/main/resources/day1.txt").inputStream()

    val list: MutableList<Int> = mutableListOf()
    var i = 0
    inputStream.bufferedReader().forEachLine {
        if (it == "") {
            list.add(i)
            i = 0
        } else {
            i += it.toInt()
        }
    }

    list.sortDescending()
    println("A is ${list[0]}")
    println("B is ${list[0] + list[1] + list[2]}")
}