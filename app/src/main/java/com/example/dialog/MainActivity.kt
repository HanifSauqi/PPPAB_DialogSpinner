package com.example.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.dialog.databinding.ActivityMainBinding
import com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
//    private val province = arrayOf(
//        "Jawa Tengah",
//        "Daerah Istimewa Yogyakarta",
//        "Bali"
//    )

//    private lateinit var city : Array<String>

    private lateinit var kehadiran  : Array<String>

    private var selectedDate: String? = null
    private var selectedTime: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//        city = resources.getStringArray(R.array.city)
        kehadiran = resources.getStringArray(R.array.kehadiran)


        with(binding) {
            val adapterkehadiran = ArrayAdapter(
                this@MainActivity,
                android.R.layout.simple_spinner_item, kehadiran
            )
            adapterkehadiran.setDropDownViewResource(

                com.google.android.material.R.layout.support_simple_spinner_dropdown_item
            )
            spinnerKehadiran.adapter = adapterkehadiran

            spinnerKehadiran.onItemSelectedListener=
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

                        if (position>0){
                            alasan.visibility = View.VISIBLE
                        }
                        else{
                            alasan.visibility = View.GONE
                        }
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }

            timePicker.setOnTimeChangedListener { view, hourOfDay, minute ->
                val amPm: String
                val formattedHour: Int

                // Tentukan AM atau PM
                if (hourOfDay >= 12) {
                    amPm = "PM"
                    formattedHour = if (hourOfDay == 12) hourOfDay else hourOfDay - 12
                } else {
                    amPm = "AM"
                    formattedHour = if (hourOfDay == 0) 12 else hourOfDay
                }

                selectedTime = String.format("%02d:%02d %s", formattedHour, minute, amPm)
                Log.d("SELECTED TIME", selectedTime!!)
            }


            datePicker.setOnDateChangeListener { _, year, month, dayOfMonth ->
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)
                val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
                selectedDate = dateFormat.format(calendar.time)
                Log.d("SELECTED DATE: ", selectedDate!!)
            }


            btnSubmit.setOnClickListener {
                if (selectedDate != null && selectedTime != null) {
                    val toastMessage = "Presensi berhasil $selectedDate jam $selectedTime"
                    Toast.makeText(this@MainActivity, toastMessage, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Pilih tanggal dan waktu terlebih dahulu",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }


            //            val adaptercity = ArrayAdapter(
//                this@MainActivity,
//                android.R.layout.simple_spinner_item, city
//            )
//            adaptercity.setDropDownViewReso
//            }urce(
//
//                com.google.android.material.R.layout.support_simple_spinner_dropdown_item
//            )
//            spinnerCity.adapter = adaptercity
//
//            spinnerCity.onItemSelectedListener=
//                object : AdapterView.OnItemSelectedListener{
//                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                        val city = city[position]
//                        Toast.makeText(this@MainActivity,city,Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onNothingSelected(p0: AdapterView<*>?) {
//                    }
//                }
//            val adapterprovince = ArrayAdapter(
//                this@MainActivity,
//                android.R.layout.simple_spinner_item, province
//            )
//            adapterprovince.setDropDownViewResource(
//                com.google.android.material.R.layout.support_simple_spinner_dropdown_item
//            )
//            spinnerProvince.adapter = adapterprovince
//
//            val adaptercity = ArrayAdapter(
//                this@MainActivity,
//                android.R.layout.simple_spinner_item, city
//            )
//            adaptercity.setDropDownViewResource(
//
//                com.google.android.material.R.layout.support_simple_spinner_dropdown_item
//            )
//            spinnerCity.adapter = adaptercity
//
//            spinnerCity.onItemSelectedListener=
//                object : AdapterView.OnItemSelectedListener{
//                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                        val city = city[position]
//                        Toast.makeText(this@MainActivity,city,Toast.LENGTH_SHORT).show()
//                    }
//
//                    override fun onNothingSelected(p0: AdapterView<*>?) {
//                    }
//                }

//            datePicker.init(
//                datePicker.year,
//                datePicker.month,
//                datePicker.dayOfMonth
//            ){_, year, monthOfYear, dayOfMonth ->
//                val selectedDate = "$dayOfMonth/${monthOfYear +1}/$year"
//                Toast.makeText(this@MainActivity,selectedDate, Toast.LENGTH_SHORT).show()
//                Log.d("SELECTED DATE: ","$dayOfMonth/${monthOfYear+1}/$year")
//            }
//            timePicker.setOnTimeChangedListener{view,hourOfday,minute ->
//                var selectedTime =String.format("%02d:%02d",hourOfday,minute)
//
//                Toast.makeText(this@MainActivity,selectedTime,
//                    Toast.LENGTH_SHORT).show()
//                Log.d("SELECTED TIME ", selectedTime)
//            }
//
//            btnShowClaendar.setOnClickListener {
//                val datePicker = DatePicker()
//                datePicker.show(supportFragmentManager,"datePicker")
//            }
//
//            btnShowDatePicker.setOnClickListener {
//                val timePicker = TimePicker()
//                timePicker.show(supportFragmentManager,"timePicker")
//            }
        }
    }

//    override fun onDateSet(p0: android.widget.DatePicker?, p1: Int, p2: Int, p3: Int) {
//        val selectedDate = "$p3/${p2+1}/$p1"
//        Toast.makeText(this@MainActivity,selectedDate,Toast.LENGTH_SHORT).show()
//    }
//
//    override fun onTimeSet(p0: android.widget.TimePicker?, p1: Int, p2: Int) {
//        val selectedTime = String.format("%02d:%02d", p1,p2)
//        Toast.makeText(this@MainActivity, selectedTime,
//            Toast.LENGTH_SHORT).show()
//    }



}