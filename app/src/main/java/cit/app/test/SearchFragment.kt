package cit.app.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class SearchFragment : Fragment() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: ImageButton
    private lateinit var resultsRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private val allMovies = mutableListOf<Movie>()
    private val filteredMovies = mutableListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize views
        searchEditText = view.findViewById(R.id.searchEditText)
        searchButton = view.findViewById(R.id.searchButton)
        resultsRecyclerView = view.findViewById(R.id.resultsRecyclerView)

        // Initialize data
        allMovies.addAll(getDummyMovies())
        filteredMovies.addAll(allMovies)

        // Set up RecyclerView
        resultsRecyclerView.layoutManager = GridLayoutManager(context, 3)
        movieAdapter = MovieAdapter(filteredMovies)
        resultsRecyclerView.adapter = movieAdapter

        // Set up search button
        searchButton.setOnClickListener {
            performSearch(searchEditText.text.toString())
        }
    }

    private fun performSearch(query: String) {
        filteredMovies.clear()

        if (query.isEmpty()) {
            filteredMovies.addAll(allMovies)
        } else {
            val lowerCaseQuery = query.lowercase(Locale.getDefault())
            filteredMovies.addAll(allMovies.filter {
                it.title.lowercase(Locale.getDefault()).contains(lowerCaseQuery)
            })
        }

        movieAdapter.notifyDataSetChanged()
    }

    private fun getDummyMovies(): List<Movie> {
        return listOf(
            Movie("Stranger Things", "https://placeholder.com/300x450", "TV-14"),
            Movie("The Witcher", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Money Heist", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Dark", "https://placeholder.com/300x450", "TV-MA"),
            Movie("The Crown", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Squid Game", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Bridgerton", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Lupin", "https://placeholder.com/300x450", "TV-MA"),
            Movie("The Queen's Gambit", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Cobra Kai", "https://placeholder.com/300x450", "TV-14"),
            Movie("Breaking Bad", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Peaky Blinders", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Narcos", "https://placeholder.com/300x450", "TV-MA"),
            Movie("Black Mirror", "https://placeholder.com/300x450", "TV-MA"),
            Movie("The Last Kingdom", "https://placeholder.com/300x450", "TV-MA")
        )
    }
}