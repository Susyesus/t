package cit.app.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GenreAdapter(private val genres: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    private var onItemClickListener: ((Genre) -> Unit)? = null

    fun setOnItemClickListener(listener: (Genre) -> Unit) {
        onItemClickListener = listener
    }

    class GenreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val genreIcon: ImageView = view.findViewById(R.id.genreIcon)
        val genreName: TextView = view.findViewById(R.id.genreName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_genre, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genre = genres[position]
        holder.genreName.text = genre.name
        holder.genreIcon.setImageResource(genre.iconResId)

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(genre)
        }
    }

    override fun getItemCount() = genres.size
}