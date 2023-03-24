package io.haider.datecalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun DateApp() {
    var dateOfUser by remember { mutableStateOf("") }
    var userDate by remember {
        mutableStateOf(
            DateValues(
                TextFieldValue(""),
                TextFieldValue(""),
                TextFieldValue(""),
            )
        )
    }
    var nowDate by remember {
        mutableStateOf(
            PresentDate(
                TextFieldValue(ObjectDate.day),
                TextFieldValue(ObjectDate.month),
                TextFieldValue(ObjectDate.year)
            )
        )
    }
    // var errorMassage by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CustomOutlinedTextField(
                value = userDate.day,
                onValueChange = { userDate = userDate.copy(day = it) },
                label = "Days",
            )
            CustomOutlinedTextField(
                value = userDate.month,
                onValueChange = { userDate = userDate.copy(month = it) },
                label = "Months",
            )
            //Spacer(modifier = Modifier.width(16.dp))
            CustomOutlinedTextField(
                value = userDate.year,
                onValueChange = { userDate = userDate.copy(year = it) },
                label = "Years",
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            CustomOutlinedTextField(
                value = nowDate.day, onValueChange = { day -> nowDate = nowDate.copy(day = day) },
                label = "Days",
            )

            CustomOutlinedTextField(
                value = nowDate.month,
                onValueChange = { month -> nowDate = nowDate.copy(month = month) },
                label = "Months",
            )
            CustomOutlinedTextField(
                value = nowDate.year,
                onValueChange = { year -> nowDate = nowDate.copy(year = year) },
                label = "Years",
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = {
                dateOfUser = PeriodDate(
                    DefaultDate("${nowDate.day.text}-${nowDate.month.text}-${nowDate.year.text}"),
                    UserDate("${userDate.day.text}-${userDate.month.text}-${userDate.year.text}")
                ).getPeriod()
            },

            ) {
            Text(text = "calculate date")
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(text = dateOfUser)
        DatePicker().DateTimePicker()
    }


}