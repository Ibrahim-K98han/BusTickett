package com.ibrahimssoft.busticket.customdialogs

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import com.ibrahimssoft.busticket.getFormattedDateTime
import java.util.*

class DatePickerFragment(val callback:(String) -> Unit)
    :DialogFragment(), DatePickerDialog.OnDateSetListener{

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }
    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        val c = Calendar.getInstance()
        c.set(p1,p2,p3)
        val selectedDate = getFormattedDateTime(c.timeInMillis,"dd/MM/yyyy")
        callback(selectedDate)
    }
}