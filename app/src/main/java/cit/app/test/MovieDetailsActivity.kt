package cit.app.test

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MovieDetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        // Get movie data from intent
        val title = intent.getStringExtra("title") ?: "Movie Title"
        val imageUrl = intent.getStringExtra("imageUrl") ?: ""
        val rating = intent.getStringExtra("rating") ?: "TV-MA"
        val description = intent.getStringExtra("description") ?:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
        val year = intent.getStringExtra("year") ?: "2023"
        val duration = intent.getStringExtra("duration") ?: "1h 30m"
        val genres = intent.getStringArrayListExtra("genres") ?: arrayListOf()

        // Set up views
        val backdropImage = findViewById<ImageView>(R.id.backdropImage)
        val titleText = findViewById<TextView>(R.id.titleText)
        val yearText = findViewById<TextView>(R.id.yearText)
        val ratingText = findViewById<TextView>(R.id.ratingText)
        val durationText = findViewById<TextView>(R.id.durationText)
        val descriptionText = findViewById<TextView>(R.id.descriptionText)
        val genreChipGroup = findViewById<ChipGroup>(R.id.genreChipGroup)
        val playButton = findViewById<Button>(R.id.playButton)
        val downloadButton = findViewById<Button>(R.id.downloadButton)

        // Populate views
        titleText.text = title
        yearText.text = year
        ratingText.text = rating
        durationText.text = duration
        descriptionText.text = description

        // Add genre chips
        for (genre in genres) {
            val chip = Chip(this)
            chip.text = genre
            chip.isClickable = true
            chip.isCheckable = false
            genreChipGroup.addView(chip)
        }

        // Load image
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.backdrop_placeholder)
            .into(backdropImage)

        // Set up buttons
        playButton.setOnClickListener {
            // Play movie implementation with ExoPlayer
            val intent = android.content.Intent(this, VideoPlayerActivity::class.java)
            intent.putExtra("videoUrl", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            intent.putExtra("title", title)
            startActivity(intent)
        }

        downloadButton.setOnClickListener {
            // Download movie implementation
            // This would be implemented with a DownloadManager in a real app
            android.widget.Toast.makeText(this, "Starting download...", android.widget.Toast.LENGTH_SHORT).show()
        }
    }
}