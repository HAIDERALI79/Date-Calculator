package io.haider.datecalculator

import androidx.compose.ui.text.input.TextFieldValue
import java.time.LocalDate

private val crtDate = LocalDate.now()

object ObjectDate {
    val day = "${crtDate.dayOfMonth}"
    val month = "${crtDate.monthValue}"
    val year = "${crtDate.year}"

}

data class PickerDate(
    var day: String,
    var month: String,
    var year: String,
)
object PickerObjects {
    var day: String=""
    var month: String=""
    var year: String=""
}

data class DateValues(
    var day: TextFieldValue,
    var month: TextFieldValue,
    var year: TextFieldValue
)

data class PresentDate(
    val day: TextFieldValue,
    val month: TextFieldValue,
    val year: TextFieldValue
)

//private val userDateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(
//    "d-M-u",
//    Locale("en", "us")
//).withResolverStyle(ResolverStyle.STRICT)
//
//fun formattedDate(): String = LocalDate.now().format(userDateFormatter)