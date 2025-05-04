package cit.app.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DownloadsFragment : Fragment() {

    private lateinit var downloadsRecyclerView: RecyclerView
    private lateinit var emptyStateLayout: LinearLayout
    private lateinit var findContentButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_downloads, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        downloadsRecyclerView = view.findViewById(R.id.downloadsRecyclerView)
        emptyStateLayout = view.findViewById(R.id.emptyStateLayout)
        findContentButton = view.findViewById(R.id.findContentButton)

        // Set up RecyclerView
        downloadsRecyclerView.layoutManager = LinearLayoutManager(context)

        // Check if there are downloads
        val downloads = getDummyDownloads()

        if (downloads.isEmpty()) {
            // Show empty state
            emptyStateLayout.visibility = View.VISIBLE
            downloadsRecyclerView.visibility = View.GONE

            findContentButton.setOnClickListener {
                // Navigate to home fragment
                val homeFragment = HomeFragment()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.flFragment, homeFragment)
                    .commit()

                // Select home tab in bottom navigation
                val bottomNavigationView = activity?.findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottomNavigationView)
                bottomNavigationView?.selectedItemId = R.id.home
            }
        } else {
            // Show downloads
            emptyStateLayout.visibility = View.GONE
            downloadsRecyclerView.visibility = View.VISIBLE

            val downloadAdapter = DownloadAdapter(downloads)
            downloadsRecyclerView.adapter = downloadAdapter
        }
    }

    private fun getDummyDownloads(): List<Download> {
        // For demo purposes, return an empty list to show the empty state
        return emptyList()

        // Uncomment to show dummy downloads
        /*
        return listOf(
            Download("Stranger Things", "https://placeholder.com/300x450", "Season 1, Episode 1", "720MB"),
            Download("The Witcher", "https://placeholder.com/300x450", "Season 1, Episode 1", "850MB"),
            Download("Money Heist", "https://placeholder.com/300x450", "Season 1, Episode 1", "650MB")
        )
        */
    }
}