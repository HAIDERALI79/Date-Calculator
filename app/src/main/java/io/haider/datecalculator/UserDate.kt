package io.haider.datecalculator

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.time.format.ResolverStyle
import java.util.*


class DateCalculator(
    private var day:String,
    private var month: String,
    private var year: String
) {


 //   private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d-M-y",
  //      Locale("en","us"))

//    @SuppressLint("SimpleDateFormat")
   private val userDateFormatter:DateTimeFormatter= DateTimeFormatter.ofPattern("d-M-u",
    Locale("en","us")).withResolverStyle(ResolverStyle.STRICT)

//     fun defaultDate(day: String, month: String, year: String): LocalDate? {
//        return getUserDate(day,month,year)
//    }

     private fun rowUserDate(): String= LocalDate.parse("$day-$month-$year",userDateFormatter).toString()
//private val date=rowUserDate()
private fun isValidUserDate():Boolean{
 //   val validDate=LocalDate.parse(date,anotherFormatter)
   // println(date)
    return try {
        rowUserDate()
       // LocalDate.parse(rowUserDate(),anotherFormatter)
        true

    }catch (e:DateTimeParseException){
        false
    }
}
    fun getUserDate(): String {
        return if (isValidUserDate()){
            rowUserDate()
        } else
            "not valid date"
        }
    }
  //  private val period: Period = Period.between(getUserDate(day, month, year), defaultDate())
//    fun basicDate(): String {
//        return "Years: ${period.years}\n Months: ${period.months} \n Days: ${period.days}"
//    }

