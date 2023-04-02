package io.haider.datecalculator

import androidx.compose.ui.text.input.TextFieldValue
import java.time.LocalDate

private val crtDate = LocalDate.now()

object ObjectDate {
    val day = "${crtDate.dayOfMonth}"
    val month = "${crtDate.monthValue}"
    val year = "${crtDate.year}"

}
object NewDate {
    lateinit var day:TextFieldValue
    lateinit var month:TextFieldValue
    lateinit var year:TextFieldValue

}


data class CustomDate(
    var day: TextFieldValue,
    var month: TextFieldValue,
    var year: TextFieldValue
)

data class PresentDate(
    val day: TextFieldValue,
    val month: TextFieldValue,
    val year: TextFieldValue
)