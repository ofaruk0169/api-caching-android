package com.example.apicachingapplication.feature_reading.domain.model

data class Contributor(
    val name: String,
    val bio: String,
    val photo: Int,
)
// switch to state + mutableStateOf if contributors become editable

