package io.haider.datecalculator

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import io.haider.datecalculator.ui.theme.DateCalculatorTheme

@OptIn(ExperimentalComposeUiApi::class)
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
    var isError by remember {
        mutableStateOf(false)
    }
    val keyboardController = LocalSoftwareKeyboardController.current
    @Composable
    fun UserValidate(text: String) {
        if (text == "Your date isn't valid") {
            isError = true
            Text(
                text = dateOfUser,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp)
            )

        } else {
            isError = false
        }

    }

    @Composable
    fun DefaultValidate(text: String) {
        if (text == "not valid default date") {
            isError = true
            Text(
                text = dateOfUser,
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(start = 8.dp)
            )

        } else {
            isError = false
        }

    }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            //   modifier = Modifier.padding(8.dp)
        ) {
            Row(
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(text = "Enter the date you want", Modifier.weight(1f))
                UserValidate(text = dateOfUser)

            }
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
                    onValueChange = {
                        userDate = userDate.copy(day = it)
                    },
                    //label = "day"
                )

                CustomOutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    value = userDate.month,
                    onValueChange = { userDate = userDate.copy(month = it) },
                    // label = "Month",
                )
                CustomOutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    value = userDate.year,
                    onValueChange = { userDate = userDate.copy(year = it) },
                    // label = "Year",
                )


                //  Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = {
                        isNowDate = false
                        isCustomDate = true
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
                        contentDescription = "Calender",
                    )
                }


            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            //    modifier = Modifier.padding(8.dp)
        ) {
            Row(
                //  verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp, end = 8.dp)

            ) {
                Text(text = "Today's Day", Modifier.weight(1f))
                DefaultValidate(text = dateOfUser)

            }
            Row(
                Modifier.width(IntrinsicSize.Max),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly

            ) {
                CustomOutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    value = nowDate.day,
                    onValueChange = { day -> nowDate = nowDate.copy(day = day) },
                    //  label = "Days",
                )

                CustomOutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    value = nowDate.month,
                    onValueChange = { month -> nowDate = nowDate.copy(month = month) },
                    //  label = "Months",
                )
                CustomOutlinedTextField(
                    modifier = Modifier
                        .weight(1f)
                        .padding(8.dp),
                    value = nowDate.year,
                    onValueChange = { year -> nowDate = nowDate.copy(year = year) },
                    //   label = "Years",
                )
                Button(
                    onClick = {
                        isCustomDate = false
                        isNowDate = true
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
                        contentDescription = "Calender",
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                dateOfUser = PeriodDate(
                    DefaultDate("${nowDate.day.text}-${nowDate.month.text}-${nowDate.year.text}"),
                    UserDate("${userDate.day.text}-${userDate.month.text}-${userDate.year.text}")
                ).getPeriod()
                keyboardController?.hide()
            },

            ) {
            Text(text = "calculate date")


        }

        Spacer(modifier = Modifier.height(30.dp))

        Column {
            Text(text = "Calculated date", modifier = Modifier.padding(start = 16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(BorderStroke(2.dp, Color.Gray), shape = RoundedCornerShape(8.dp))


            ) {
                if (!isError) {
                    Column {


                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Text(text = "Years")
                            Text(text = "Months")
                            Text(text = "Days")


                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceAround,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(4.dp)
                        ) {
                            Text(text = PeriodValue.periodYear)
                            Text(text = PeriodValue.periodMonth)
                            Text(text = PeriodValue.periodDay)
                        }
                        Spacer(modifier = Modifier.height(48.dp))


                    }
                }

                //    Text(text = dateOfUser)
            }

        }
    }
    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("ok")
            negativeButton("cancel")
        }
    ) {
        if (isCustomDate) {
            datepicker {
                userDate = userDate.copy(
                    day = TextFieldValue("${it.dayOfMonth}"),
                    month = TextFieldValue("${it.monthValue}"),
                    year = TextFieldValue("${it.year}")
                )

            }
        }
        if (isNowDate) {
            datepicker {
                nowDate = nowDate.copy(
                    day = TextFieldValue("${it.dayOfMonth}"),
                    month = TextFieldValue("${it.monthValue}"),
                    year = TextFieldValue("${it.year}")
                )
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

