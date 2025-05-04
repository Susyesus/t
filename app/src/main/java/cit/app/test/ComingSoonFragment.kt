package cit.app.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ComingSoonFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_coming_soon, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val comingSoonRecyclerView = view.findViewById<RecyclerView>(R.id.comingSoonRecyclerView)

        // Set up RecyclerView
        comingSoonRecyclerView.layoutManager = LinearLayoutManager(context)
        val comingSoonAdapter = ComingSoonAdapter(getDummyComingSoon())
        comingSoonRecyclerView.adapter = comingSoonAdapter
    }

    private fun getDummyComingSoon(): List<ComingSoon> {
        return listOf(
            ComingSoon(
                "Stranger Things Season 5",
                "https://placeholder.com/800x450",
                "Coming December 2023",
                "The epic conclusion to the Stranger Things saga. The kids of Hawkins face their greatest challenge yet as they confront the ultimate evil from the Upside Down.",
                "Sci-Fi, Horror, Drama"
            ),
            ComingSoon(
                "The Witcher Season 3",
                "https://placeholder.com/800x450",
                "Coming October 2023",
                "Geralt of Rivia continues his journey protecting Princess Cirilla while navigating the increasingly dangerous Continent.",
                "Fantasy, Action, Adventure"
            ),
            ComingSoon(
                "Squid Game Season 2",
                "https://placeholder.com/800x450",
                "Coming January 2024",
                "The games continue with new players, higher stakes, and deadlier challenges.",
                "Thriller, Drama, Action"
            )
        )
    }
}