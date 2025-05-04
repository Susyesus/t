package cit.app.test

data class Movie(
    val title: String,
    val imageUrl: String,
    val rating: String,
    val description: String = "",
    val year: String = "",
    val duration: String = "",
    val genres: List<String> = listOf() // Added genres field
)
