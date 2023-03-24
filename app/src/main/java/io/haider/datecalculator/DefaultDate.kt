package io.haider.datecalculator

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class DefaultDate(
//    private var day: String,
//    private var month: String,
//    private var year: String
    private var defaultDate: String
) {
   private fun defaultDate(): LocalDate = DateFormatter(defaultDate).dateFormatter()

    fun getDefaultDate(): LocalDate? {
        return if (DateFormatter(defaultDate).isValidDate()) {
            defaultDate()
        } else
            null
    }

}