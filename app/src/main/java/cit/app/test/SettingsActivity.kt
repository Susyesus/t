package cit.app.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast

class SettingsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val backButton = findViewById<ImageButton>(R.id.backButton)
        val wifiOnlySwitch = findViewById<Switch>(R.id.wifiOnlySwitch)
        val autoPlaySwitch = findViewById<Switch>(R.id.autoPlaySwitch)
        val smartDownloadsSwitch = findViewById<Switch>(R.id.smartDownloadsSwitch)
        val videoQualityText = findViewById<TextView>(R.id.videoQualityText)
        val audioQualityText = findViewById<TextView>(R.id.audioQualityText)
        val storageUsageText = findViewById<TextView>(R.id.storageUsageText)
        val deleteAllButton = findViewById<Button>(R.id.deleteAllButton)
        val aboutDevelopersButton = findViewById<Button>(R.id.aboutDevelopersButton)

        // Set up back button
        backButton.setOnClickListener {
            finish()
        }

        // Set up switches
        wifiOnlySwitch.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Wi-Fi only downloads: $isChecked", Toast.LENGTH_SHORT).show()
        }

        autoPlaySwitch.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Auto-play next episode: $isChecked", Toast.LENGTH_SHORT).show()
        }

        smartDownloadsSwitch.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Smart downloads: $isChecked", Toast.LENGTH_SHORT).show()
        }

        // Set up text views
        videoQualityText.setOnClickListener {
            showVideoQualityDialog()
        }

        audioQualityText.setOnClickListener {
            showAudioQualityDialog()
        }

        storageUsageText.setOnClickListener {
            showStorageUsageDialog()
        }

        // Set up buttons
        deleteAllButton.setOnClickListener {
            showDeleteConfirmationDialog()
        }

        aboutDevelopersButton.setOnClickListener {
            val intent = Intent(this, AboutDevelopersActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showVideoQualityDialog() {
        // In a real app, this would show a dialog to select video quality
        Toast.makeText(this, "Video quality options", Toast.LENGTH_SHORT).show()
    }

    private fun showAudioQualityDialog() {
        // In a real app, this would show a dialog to select audio quality
        Toast.makeText(this, "Audio quality options", Toast.LENGTH_SHORT).show()
    }

    private fun showStorageUsageDialog() {
        // In a real app, this would show a dialog with storage usage details
        Toast.makeText(this, "Storage usage details", Toast.LENGTH_SHORT).show()
    }

    private fun showDeleteConfirmationDialog() {
        // In a real app, this would show a confirmation dialog
        Toast.makeText(this, "All downloads deleted", Toast.LENGTH_SHORT).show()
    }
}