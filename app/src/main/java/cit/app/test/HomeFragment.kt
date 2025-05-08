package cit.app.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup genres
        val genresRecyclerView = view.findViewById<RecyclerView>(R.id.genresRecyclerView)
        genresRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val genreAdapter = GenreAdapter(getGenres())
        genresRecyclerView.adapter = genreAdapter

        // Set genre click listener
        genreAdapter.setOnItemClickListener { genre ->
            val genreFragment = GenreFragment.newInstance(genre.name)
            parentFragmentManager.beginTransaction()
                .replace(R.id.flFragment, genreFragment)
                .addToBackStack(null)
                .commit()
        }

        // Setup featured content
        val featuredRecyclerView = view.findViewById<RecyclerView>(R.id.featuredRecyclerView)
        featuredRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val featuredAdapter = MovieAdapter(getDummyFeaturedMovies())
        featuredRecyclerView.adapter = featuredAdapter

        // Set movie click listener
        featuredAdapter.setOnItemClickListener { movie ->
            val intent = Intent(activity, MovieDetailsActivity::class.java)
            intent.putExtra("title", movie.title)
            intent.putExtra("imageUrl", movie.imageUrl)
            intent.putExtra("rating", movie.rating)
            intent.putExtra("description", movie.description)
            intent.putExtra("year", movie.year)
            intent.putExtra("duration", movie.duration)
            startActivity(intent)
        }

        // Setup trending content
        val trendingRecyclerView = view.findViewById<RecyclerView>(R.id.trendingRecyclerView)
        trendingRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val trendingAdapter = MovieAdapter(getDummyTrendingMovies())
        trendingRecyclerView.adapter = trendingAdapter

        // Set movie click listener
        trendingAdapter.setOnItemClickListener { movie ->
            val intent = Intent(activity, MovieDetailsActivity::class.java)
            intent.putExtra("title", movie.title)
            intent.putExtra("imageUrl", movie.imageUrl)
            intent.putExtra("rating", movie.rating)
            intent.putExtra("description", movie.description)
            intent.putExtra("year", movie.year)
            intent.putExtra("duration", movie.duration)
            startActivity(intent)
        }

        // Setup popular content
        val popularRecyclerView = view.findViewById<RecyclerView>(R.id.popularRecyclerView)
        popularRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val popularAdapter = MovieAdapter(getDummyPopularMovies())
        popularRecyclerView.adapter = popularAdapter

        // Set movie click listener
        popularAdapter.setOnItemClickListener { movie ->
            val intent = Intent(activity, MovieDetailsActivity::class.java)
            intent.putExtra("title", movie.title)
            intent.putExtra("imageUrl", movie.imageUrl)
            intent.putExtra("rating", movie.rating)
            intent.putExtra("description", movie.description)
            intent.putExtra("year", movie.year)
            intent.putExtra("duration", movie.duration)
            startActivity(intent)
        }
    }

    private fun getGenres(): List<Genre> {
        return listOf(
            Genre(1, "Action", R.drawable.ic_genre_action),
            Genre(2, "Comedy", R.drawable.ic_genre_comedy),
            Genre(3, "Drama", R.drawable.ic_genre_drama),
            Genre(4, "Sci-Fi", R.drawable.ic_genre_scifi),
            Genre(5, "Horror", R.drawable.ic_genre_horror),
            Genre(6, "Romance", R.drawable.ic_genre_romance),
            Genre(7, "Thriller", R.drawable.ic_genre_thriller),
            Genre(8, "Fantasy", R.drawable.ic_genre_fantasy),
            Genre(9, "Crime", R.drawable.ic_genre_crime)
        )
    }

    private fun getDummyFeaturedMovies(): List<Movie> {
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
            )
        )
    }

    private fun getDummyTrendingMovies(): List<Movie> {
        return listOf(
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
            )
        )
    }

    private fun getDummyPopularMovies(): List<Movie> {
        return listOf(
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