package io.haider.datecalculator
import java.time.Period
import io.haider.datecalculator.PeriodValue

class PeriodDate(
    private var defaultDate: DefaultDate,
    private var userDate: UserDate
) {
 //   private var period:Period = TODO()

    fun getPeriod(): String {

       return  if (userDate.getUserDate() == null) {
         "Your date isn't valid"
        }
         else if (defaultDate.getDefaultDate()==null){
           "not valid default date"
        }
        else {
         val period = Period.between(userDate.getUserDate(), defaultDate.getDefaultDate())
           PeriodValue.periodDay="${period.days}"
           PeriodValue.periodMonth="${period.months}"
           PeriodValue.periodYear="${period.years}"
            "Years: ${period.years}\n Months: ${period.months} \n Days: ${period.days}"
        }

    }
}