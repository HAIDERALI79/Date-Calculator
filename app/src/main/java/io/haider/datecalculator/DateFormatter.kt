package io.haider.datecalculator

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle
import java.util.*

class DateFormatter(
    private var date: String
) {
    private val userDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(
        "d-M-u",
        Locale("en", "us")
    ).withResolverStyle(ResolverStyle.STRICT)

    fun dateFormatter(): LocalDate = LocalDate.parse(date, userDateFormatter)
    fun isValidDate(): Boolean {

        return try {
            dateFormatter()
            true

        } catch (e: DateTimeParseException) {
            false

        }

    }
}