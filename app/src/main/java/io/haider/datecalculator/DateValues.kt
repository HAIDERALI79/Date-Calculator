package io.haider.datecalculator

import androidx.compose.ui.text.input.TextFieldValue
import java.time.LocalDate
import java.time.Period

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
object PeriodValue{
     var periodDay:String="0"
     var periodMonth:String="0"
     var periodYear:String="0"
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
//public fun clearTextFieldValues(vararg textFields: CustomDate){
//    textFields.forEach {
//        it.day=TextFieldValue("")
//        it.month=TextFieldValue("")
//        it.year=TextFieldValue("")
//
//    }
//}
