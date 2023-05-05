package com.example.pr19criminalintent

import java.util.UUID
import java.util.Date

class Crime (val id: UUID = UUID.randomUUID()) {
    var title: String = ""
    var date: Date = Date()
    var isSolved: Boolean = false
}