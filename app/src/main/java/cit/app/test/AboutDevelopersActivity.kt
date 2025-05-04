package cit.app.test

import android.app.Activity
import android.os.Bundle
import android.widget.ImageButton

class AboutDevelopersActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_developers)

        val backButton = findViewById<ImageButton>(R.id.backButton)

        // Set up back button
        backButton.setOnClickListener {
            finish()
        }
    }
}