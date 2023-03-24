package io.haider.datecalculator

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import kotlinx.coroutines.delay
import java.util.*
import kotlin.concurrent.thread

class DatePicker {
    @Composable
    fun DateTimePicker() {
        val context = LocalContext.current
        val calendar = Calendar.getInstance()

        var stateDay by remember { mutableStateOf("") }
        var stateMonth by remember { mutableStateOf("") }
        var stateYear by remember { mutableStateOf("") }

        val year = calendar[Calendar.YEAR]
        val month = calendar[Calendar.MONTH]
        val dayOfMonth = calendar[Calendar.DAY_OF_MONTH]
        val datePicker = DatePickerDialog(
            context,
            { _: DatePicker?, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
             //   selectedDateText = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
             //   selectedDateText=CurrentDate.datePicked
                stateDay="$selectedDayOfMonth"
                stateMonth="$selectedMonth"
                stateYear="$selectedYear"
            }, year, month, dayOfMonth
        )
        Text(text =ObjectDate.datePicked, style = TextStyle(
            color = Color.Black
        ))
        Button(onClick = { datePicker.show()}) {
            Text(text = "show date")



        }
        println("this is a selected date:${ObjectDate.datePicked}")

    }
}