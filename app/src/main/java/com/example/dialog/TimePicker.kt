package com.example.dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.icu.util.Calendar
import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.DialogFragment


class TimePicker : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(
            requireActivity(),
            activity as OnTimeSetListener,
            hourOfDay,
            minute,
            DateFormat.is24HourFormat(activity)
        )
    }
}