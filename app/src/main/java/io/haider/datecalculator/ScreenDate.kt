package io.haider.datecalculator

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.marosseleng.compose.material3.datetimepickers.date.ui.dialog.DatePickerDialog
import io.haider.datecalculator.ui.theme.DateCalculatorTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DateApp() {
    var dateOfUser by remember { mutableStateOf("") }
    var userDate by remember {
        mutableStateOf(
            DateValues(
                TextFieldValue(),
                TextFieldValue(),
                TextFieldValue(),
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

    var isDialogShown: Boolean by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CustomOutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = userDate.day,
                onValueChange = { userDate = userDate.copy(day = it) },
                label = "day"
            )
            CustomOutlinedTextField(
                //    modifier =Modifier.customMod(60,70),
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = userDate.month,
                onValueChange = { userDate = userDate.copy(month = it) },
                label = "Month",
            )
            //Spacer(modifier = Modifier.width(16.dp))
            CustomOutlinedTextField(
                //     modifier =Modifier.customMod(60,70),
                modifier = Modifier.weight(1f),
                value = userDate.year,
                onValueChange = { userDate = userDate.copy(year = it) },
                label = "Year",
            )
                Button(
                    onClick = { isDialogShown = true },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(238, 139, 61),
                        contentColor = Color(92, 32, 48),

                        )
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        //   modifier = Modifier.padding(8.dp),
                        contentDescription = "Localized description",
                        //modifier = Modifier.customMod(40,40)
                    )
                }
            if (isDialogShown) {


                DatePickerDialog(onDismissRequest = {
                    isDialogShown = false
                },
                    onDateChange = {
                        userDate = userDate.copy(
                            day = TextFieldValue("${it.dayOfMonth}"),
                            month = TextFieldValue("${it.monthValue}"),
                            year = TextFieldValue("${it.year}")
                        )
                        isDialogShown = false
                    },
                    title = { Text(text = "specific date") }

                )
            }

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
        DatePicker().DateTimePicker(userDate)
    }


}

private fun Modifier.customMod(): Modifier {
    return padding(top = OutlinedTextFieldTopPadding)
        //  .size(width = width.dp, height = height.dp)
        .defaultMinSize(
            minWidth = TextFieldDefaults.MinWidth,
            minHeight = TextFieldDefaults.MinHeight
        )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DateCalculatorTheme {
        DateApp()
    }
}

