package io.haider.datecalculator

import java.time.Duration
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter


class DateCalculator(
    private var day:String,
    private var month: String,
  private  var year: String
) {


    private val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("d-MM-yyyy")
    private fun currentDate(): LocalDate? {
        return LocalDate.now()
    }

    private fun getUserDate(day: String, month: String, year: String): LocalDate? {
        return LocalDate.parse("$day-$month-$year", dateFormatter)

    }

    private val period: Period = Period.between(getUserDate(day, month, year), currentDate())
    fun basicDate(): String {
        return " ${period.years} ${period.months} ${period.days}"
    }

//    init {
//        println(
//            " ${period.years} ${period.months} ${period.days}"
//        )
//        fun basicDate(): String {
//            return " ${period.years} ${period.months} ${period.days}"
//        }
//    }
}
