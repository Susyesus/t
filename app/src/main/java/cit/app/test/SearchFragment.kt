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
        allMovies.addAll(getAllMovies())
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

    private fun getAllMovies(): List<Movie> {
        return listOf(
            Movie(
                "Stranger Things",
                "https://m.media-amazon.com/images/M/MV5BMjg2NmM0MTEtYWY2Yy00NmFlLTllNTMtMjVkZjEwMGVlNzdjXkEyXkFqcGc@._V1_.jpg",
                "TV-14",
                "A group of kids face supernatural forces in the small town of Hawkins.",
                "2016",
                "50m",
                listOf("Sci-Fi", "Horror", "Drama")
            ),
            Movie(
                "The Witcher",
                "https://static.wikia.nocookie.net/witcher/images/a/a4/Netflix_poster_s1.jpg/revision/latest/scale-to-width-down/1200?cb=20191120213257",
                "TV-MA",
                "Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world.",
                "2019",
                "1h",
                listOf("Fantasy", "Action", "Adventure")
            ),
            Movie(
                "Money Heist",
                "https://static.wikia.nocookie.net/netflix/images/0/0e/MH_S5_Promotional.jpg/revision/latest/scale-to-width-down/1200?cb=20210904021400",
                "TV-MA",
                "A criminal mastermind who goes by The Professor has a plan to pull off the biggest heist in history.",
                "2017",
                "50m",
                listOf("Crime", "Drama", "Thriller")
            ),
            Movie(
                "Dark",
                "https://upload.wikimedia.org/wikipedia/en/d/da/DarkNetflixPosterEnglish.jpg",
                "TV-MA",
                "A family saga with a supernatural twist, set in a German town where the disappearance of two children exposes the relationships among four families.",
                "2017",
                "1h",
                listOf("Sci-Fi", "Thriller", "Mystery")
            ),
            Movie(
                "The Crown",
                "https://resizing.flixster.com/aX9Yz5sNV2WpBA5CoENzIl9RbTM=/ems.cHJkLWVtcy1hc3NldHMvdHZzZWFzb24vUlRUVjI2NTU1OS53ZWJw",
                "TV-MA",
                "Follows the political rivalries and romance of Queen Elizabeth II's reign and the events that shaped the second half of the twentieth century.",
                "2016",
                "1h",
                listOf("Drama", "History", "Biography")
            ),
            Movie(
                "Squid Game",
                "https://asianwiki.com/images/0/0e/Squid_Game-p2.jpg",
                "TV-MA",
                "Hundreds of cash-strapped players accept a strange invitation to compete in children's games.",
                "2021",
                "1h",
                listOf("Thriller", "Drama", "Action")
            ),
            Movie(
                "Bridgerton",
                "https://m.media-amazon.com/images/M/MV5BZmRjNDNlMDMtNDZlMS00NzE4LTk0OGMtYjQyMWY3YWFmY2I5XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg",
                "TV-MA",
                "Wealth, lust, and betrayal set against the backdrop of Regency-era England.",
                "2020",
                "1h",
                listOf("Drama", "Romance", "History")
            ),
            Movie(
                "Lupin",
                "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p19204904_b_v13_al.jpg",
                "TV-MA",
                "Inspired by the adventures of Arsène Lupin, gentleman thief Assane Diop sets out to avenge his father for an injustice inflicted by a wealthy family.",
                "2021",
                "45m",
                listOf("Crime", "Mystery", "Action")
            ),
            Movie(
                "The Queen's Gambit",
                "https://upload.wikimedia.org/wikipedia/en/1/12/The_Queen%27s_Gambit_%28miniseries%29.png",
                "TV-MA",
                "Orphaned at the tender age of nine, prodigious introvert Beth Harmon discovers and masters the game of chess in 1960s USA.",
                "2020",
                "1h",
                listOf("Drama", "Sport")
            ),
            Movie(
                "Cobra Kai",
                "https://static.wikia.nocookie.net/netflix/images/a/a3/Cobra_Kai_S4_Poster.jpg/revision/latest?cb=20220413111556",
                "TV-14",
                "Decades after their 1984 All Valley Karate Tournament bout, a middle-aged Daniel LaRusso and Johnny Lawrence find themselves martial-arts rivals again.",
                "2018",
                "30m",
                listOf("Action", "Comedy", "Drama")
            ),
            Movie(
                "Breaking Bad",
                "https://m.media-amazon.com/images/M/MV5BMzU5ZGYzNmQtMTdhYy00OGRiLTg0NmQtYjVjNzliZTg1ZGE4XkEyXkFqcGc@._V1_.jpg",
                "TV-MA",
                "A high school chemistry teacher diagnosed with inoperable lung cancer turns to manufacturing and selling methamphetamine in order to secure his family's future.",
                "2008",
                "49m",
                listOf("Crime", "Drama", "Thriller")
            ),
            Movie(
                "Peaky Blinders",
                "https://m.media-amazon.com/images/M/MV5BOGM0NGY3ZmItOGE2ZC00OWIxLTk0N2EtZWY4Yzg3ZDlhNGI3XkEyXkFqcGc@._V1_.jpg",
                "TV-MA",
                "A gangster family epic set in 1900s England, centering on a gang who sew razor blades in the peaks of their caps.",
                "2013",
                "1h",
                listOf("Crime", "Drama")
            ),
            Movie(
                "Narcos",
                "https://m.media-amazon.com/images/M/MV5BNzQwOTcwMzIwN15BMl5BanBnXkFtZTgwMjYxMTA0NjE@._V1_.jpg",
                "TV-MA",
                "A chronicled look at the criminal exploits of Colombian drug lord Pablo Escobar.",
                "2015",
                "50m",
                listOf("Crime", "Drama", "Biography")
            ),
            Movie(
                "Black Mirror",
                "https://static.wikia.nocookie.net/best-tv-shows/images/6/66/Black_Mirror.jpg/revision/latest?cb=20220528102419",
                "TV-MA",
                "An anthology series exploring a twisted, high-tech multiverse where humanity's greatest innovations and darkest instincts collide.",
                "2011",
                "1h",
                listOf("Sci-Fi", "Drama", "Thriller")
            ),
            Movie(
                "The Last Kingdom",
                "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p12079367_b_v8_an.jpg",
                "TV-MA",
                "As Alfred the Great defends his kingdom from Norse invaders, Uhtred - born a Saxon but raised by Vikings - seeks to claim his ancestral birthright.",
                "2015",
                "1h",
                listOf("Action", "Drama", "History")
            )
        )
    }
}