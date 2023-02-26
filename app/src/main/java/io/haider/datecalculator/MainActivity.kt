package io.haider.datecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import io.haider.datecalculator.ui.theme.DateCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DateCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
              //     DateCalculator("10","12","1992")
                    ReadDate()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
   // Text(text = "Hello $name!")
}
@Composable
fun ReadDate(){
    var dateOfUser by remember { mutableStateOf("") }

    var dateOfUser2:String=""
    var textDay by remember { mutableStateOf(TextFieldValue("")) }
    var textMonth by remember { mutableStateOf(TextFieldValue("")) }
    var textYear by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    TextField(value = textDay, onValueChange = {newText ->textDay=newText}, label = { Text(text = "Days")})
    TextField(value = textMonth, onValueChange = {newText ->textMonth=newText},label = { Text(text = "Months")})
    TextField(value = textYear, onValueChange = {newText ->textYear=newText},label = { Text(text = "Years")})
        Button(
            onClick = {
           dateOfUser=  DateCalculator (textDay.text, textMonth.text, textYear.text).basicDate()

            },

            ) {
            Text(text = "calculate date")
        }
        println(dateOfUser)
        Text(text = dateOfUser)
}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DateCalculatorTheme {
        Greeting("Android")
    }
}