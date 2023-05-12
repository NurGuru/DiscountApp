package data.source

class DataEntry {
    fun enterInt(): Int {
        val data: Int
        var input = readln().toIntOrNull()
        while (input == null) {
            println("Введите коректные данные!")
            input = readln().toIntOrNull()
        }
        data = input
        return data
    }
}