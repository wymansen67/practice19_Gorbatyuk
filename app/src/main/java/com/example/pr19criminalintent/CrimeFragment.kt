package com.example.pr19criminalintent

import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class CrimeFragment : Fragment() {
    private lateinit var titleField: EditText
    private lateinit var crime: Crime
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var fab: ExtendedFloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)

        titleField = view.findViewById(R.id.crime_title) as EditText
        fab = view.findViewById(R.id.fab1) as ExtendedFloatingActionButton

        fab.apply {
            isEnabled = false
        }
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH) + 1
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val hours = calendar.get(Calendar.HOUR_OF_DAY)
        val minutes = calendar.get(Calendar.MINUTE)

        var date = view.findViewById(R.id.date) as TextView
        date.text = "$day.$month.$year $hours:$minutes"

        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int, count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int, before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    crime.isSloved = isChecked
                    fab.isEnabled = isEnabled
                    fab.apply {
                        val calendar = Calendar.getInstance()
                        val year = calendar.get(Calendar.YEAR)
                        val month = calendar.get(Calendar.MONTH) + 1
                        val day = calendar.get(Calendar.DAY_OF_MONTH)
                        val hours = calendar.get(Calendar.HOUR_OF_DAY)
                        val minutes = calendar.get(Calendar.MINUTE)
                        contentDescription = "$day.$month.$year $hours:$minutes"
                    }
                } else {
                    crime.isSloved=false
                    fab.isEnabled=false
                    fab.contentDescription = "..."
                }
            }
        }

        fab.setOnClickListener{
            startActivity(Intent(this@CrimeFragment.requireContext(),MainActivity2::class.java))
        }
    }
}