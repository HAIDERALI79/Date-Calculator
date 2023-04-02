package io.haider.datecalculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import io.haider.datecalculator.ui.theme.DateCalculatorTheme

@Composable
fun DateApp() {
    var dateOfUser by remember { mutableStateOf("") }
    var userDate by remember {
        mutableStateOf(
            CustomDate(
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
    val dialogState = rememberMaterialDialogState()
    var isCustomDate by remember {
        mutableStateOf(false)
    }
    var isNowDate by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            Modifier.width(IntrinsicSize.Max),
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
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = userDate.month,
                onValueChange = { userDate = userDate.copy(month = it) },
                label = "Month",
            )
            CustomOutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = userDate.year,
                onValueChange = { userDate = userDate.copy(year = it) },
                label = "Year",
            )


            //  Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    isCustomDate=true
                    dialogState.show()},
                modifier = Modifier
                    .padding(end = 8.dp, top = 8.dp)
                    .size(height = 55.dp, width = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(238, 139, 61),
                    contentColor = Color(92, 32, 48),

                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Localized description",
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
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = nowDate.day, onValueChange = { day -> nowDate = nowDate.copy(day = day) },
                label = "Days",
            )

            CustomOutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = nowDate.month,
                onValueChange = { month -> nowDate = nowDate.copy(month = month) },
                label = "Months",
            )
            CustomOutlinedTextField(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                value = nowDate.year,
                onValueChange = { year -> nowDate = nowDate.copy(year = year) },
                label = "Years",
            )
            Button(
                onClick = {
                    isNowDate=true
                    dialogState.show()
                          },
                modifier = Modifier
                    .padding(end = 8.dp, top = 8.dp)
                    .size(height = 55.dp, width = 60.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(238, 139, 61),
                    contentColor = Color(92, 32, 48),

                    )
            ) {
                Icon(
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "Localized description",
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = {
                dateOfUser = PeriodDate(
                    DefaultDate("${nowDate.day.text}-${nowDate.month.text}-${nowDate.year.text}"),
                    UserDate("${userDate.day?.text}-${userDate.month?.text}-${userDate.year?.text}")
                ).getPeriod()

            },

            ) {
            Text(text = "calculate date")
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(text = dateOfUser)
    }
    MaterialDialog (
        dialogState = dialogState,
        buttons = {
            positiveButton("ok")
            negativeButton("cancel")
        }
    ){
        if (isCustomDate) {
            datepicker {
                userDate = userDate.copy(
                    day = TextFieldValue("${it.dayOfMonth}"),
                    month = TextFieldValue("${it.monthValue}"),
                    year = TextFieldValue("${it.year}")
                )
                isCustomDate=false

            }
        }
        if (isNowDate) {
            datepicker {
                nowDate = nowDate.copy(
                    day = TextFieldValue("${it.dayOfMonth}"),
                    month = TextFieldValue("${it.monthValue}"),
                    year = TextFieldValue("${it.year}")
                )
                isNowDate=false
            }
        }
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DateCalculatorTheme {
        DateApp()
    }
}

