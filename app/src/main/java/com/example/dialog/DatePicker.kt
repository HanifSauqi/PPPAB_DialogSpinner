package com.example.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DatePicker : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
//        return super.onCreateDialog(savedInstanceState)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val monthOfYear = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            return DatePickerDialog(
                requireActivity(),
                            activity as OnDateSetListener,
                year,monthOfYear,dayOfMonth
            )
    }
}