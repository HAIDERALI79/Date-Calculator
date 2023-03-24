package io.haider.datecalculator

import androidx.compose.ui.text.input.TextFieldValue
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.*


private val crtDate = LocalDate.now()

object ObjectDate {
   // var date: String = formattedDate()
    val day = crtDate.dayOfMonth.toString()
    val month = crtDate.month.value.toString()
    val year = crtDate.year.toString()
    var datePicked: String = ""

}

data class DateValues(
    val day: TextFieldValue,
    val month: TextFieldValue,
    val year: TextFieldValue
)

data class PresentDate(
    val day: TextFieldValue,
    val month: TextFieldValue,
    val year: TextFieldValue
)

private val userDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(
    "d-M-u",
    Locale("en", "us")
).withResolverStyle(ResolverStyle.STRICT)

fun formattedDate(): String = LocalDate.now().format(userDateFormatter)