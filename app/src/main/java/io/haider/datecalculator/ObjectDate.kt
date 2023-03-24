package io.haider.datecalculator

import java.time.LocalDate
import java.time.Month
import java.time.Year

var currentDate: LocalDate =LocalDate.now()
object CurrentDate {
       var day = currentDate.dayOfMonth
      var month = currentDate.month.value
      var year= currentDate.year
}