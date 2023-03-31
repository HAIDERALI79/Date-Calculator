package io.haider.datecalculator

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import java.util.*

class DatePicker {
    @Composable
    fun DateTimePicker(userDate: DateValues) {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()
//
//       val stateDate by remember { mutableStateOf(PickerDate(
//           day = "",
//           month = "",
//           year = "",
//       ))}
      //  var selectedDateText by remember { mutableStateOf("") }
//        var stateYear by remember { mutableStateOf("") }
        var pickerValues by remember {
            mutableStateOf(
                DateValues(
                    TextFieldValue(),
                    TextFieldValue(),
                    TextFieldValue()
                )
            )
        }
        var userPickerDate by remember { mutableStateOf(userDate) }
        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        val datePicker = DatePickerDialog(
            context,
            { _: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
            //   stateDate = PickerDate(day = "$selectedDayOfMonth", month = "${selectedMonth + 1}", year = "$selectedYear")
//                stateDate.day="$selectedDayOfMonth"
//                stateDate.month="${selectedMonth + 1}"
//                stateDate.year= "$selectedYear"
                //   selectedDateText=ObjectDate.datePicked
//                stateDay="$selectedDayOfMonth"
//                stateMonth="$selectedMonth"
//                stateYear="$selectedYear"
                userPickerDate = userDate.copy(
                    day = TextFieldValue("$selectedDayOfMonth"),
                    month = TextFieldValue("${selectedMonth + 1}"),
                    year = TextFieldValue("$selectedYear")
                )
                pickerValues = pickerValues.copy(day = TextFieldValue("$selectedDayOfMonth"))
                pickerValues = pickerValues.copy(month = TextFieldValue("$selectedMonth"))
                pickerValues = pickerValues.copy(year = TextFieldValue("$selectedYear"))
            }, year, month, dayOfMonth
        )

        Button(onClick = {
            datePicker.show()
            //   stateDate="${ObjectDate.datePicked}"
        }
        ) {
            Text(text = "show date")


        }
        Text(
            text = "${pickerValues.day.text}/${pickerValues.month.text}/${pickerValues.year.text}", style = TextStyle(
                color = Color.Black
            )
        )
        // println("this is a selected date:${ObjectDate.datePicked}")

    }
}

