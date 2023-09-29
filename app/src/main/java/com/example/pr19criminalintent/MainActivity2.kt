package com.example.pr19criminalintent

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.pr19criminalintent.databinding.ActivityMain2Binding
import com.example.pr19criminalintent.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMain2Binding
    private lateinit var fab: FloatingActionButton
    private lateinit var snackbar:Snackbar
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val text = getString(R.string.pressed_button)
        val parentLayout = findViewById<View>(android.R.id.content)
        snackbar = Snackbar.make(parentLayout, text, Snackbar.LENGTH_LONG)
        snackbar.setAction("Click"
        ) { startActivity(Intent(this@MainActivity2, CrimeFragment::class.java)) }
        snackbar.show()

        fab = bindingClass.fab2
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity2, MainActivity::class.java))
        }
    }
}