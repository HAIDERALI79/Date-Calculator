package io.haider.datecalculator

import java.time.Period

class PeriodDate(
    private var defaultDate: DefaultDate,
    private var userDate: UserDate
) {
    fun getPeriod(): String {
        return if (userDate.getUserDate() == null || defaultDate.getDefaultDate()==null) {
            "not valid date"
        } else {
            val period: Period = Period.between(userDate.getUserDate(), defaultDate.getDefaultDate())
            "Years: ${period.years}\n Months: ${period.months} \n Days: ${period.days}"
        }
    }
}