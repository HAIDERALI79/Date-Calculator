package io.haider.datecalculator
import java.time.LocalDate
class UserDate(
    private var date: String
) {

  private fun userDate():LocalDate= DateFormatter(date).dateFormatter()

    fun getUserDate(): LocalDate? {
        return if (DateFormatter(date).isValidDate()){
            userDate()

        } else
            null
        }
    }

