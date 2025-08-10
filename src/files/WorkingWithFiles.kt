package files

import java.io.File

fun main() {
    val file = File("todo_list.txt")

    while (true) {
        val codes = CodeType.entries
        print("enter the operation code (")
        for (code in codes) {
            print("${code.ordinal} - ${code.title}, ")
        }
        print("): ")

        val codeInd = readln().toInt()
        val codeHumanType = codes[codeInd]

        when(codeHumanType) {
            CodeType.REGISTER -> {
                print("write the todo item: ")
                val todoItem = readln()
                file.appendText("$todoItem\n")
            }
            CodeType.EXIT -> break
            CodeType.SHOW_ALL_ITEMS -> {
                val text = file.readLines()
                for ((ind, line) in text.withIndex()) {
                    println("$ind - $line")
                }
            }
        }
    }
}