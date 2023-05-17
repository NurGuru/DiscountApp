package data.source

class CsvParser {

    fun parse(lines: List<String>, delimiter: Char): List<List<String>> =
        lines.map { parse(it, delimiter) }.toList()

    fun parse(line: String, delimiter: Char): List<String> = line.split(delimiter, ignoreCase = false)

}