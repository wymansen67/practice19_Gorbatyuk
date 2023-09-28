package com.example.pr19criminalintent

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pr19criminalintent.databinding.ActivityMain2Binding
import com.example.pr19criminalintent.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMain2Binding
    private lateinit var fab: FloatingActionButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        val text = getString(R.string.pressed_button)
        val parentLayout = findViewById<View>(android.R.id.content)
        Snackbar.make(parentLayout,text, Snackbar.LENGTH_LONG).show()

        fab = bindingClass.fab2
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity2, MainActivity::class.java))
        }
    }
}