package cit.app.test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ComingSoonAdapter(private val comingSoonList: List<ComingSoon>) :
    RecyclerView.Adapter<ComingSoonAdapter.ComingSoonViewHolder>() {

    class ComingSoonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val comingSoonImage: ImageView = view.findViewById(R.id.comingSoonImage)
        val comingSoonTitle: TextView = view.findViewById(R.id.comingSoonTitle)
        val comingSoonDate: TextView = view.findViewById(R.id.comingSoonDate)
        val comingSoonDescription: TextView = view.findViewById(R.id.comingSoonDescription)
        val comingSoonGenres: TextView = view.findViewById(R.id.comingSoonGenres)
        val remindMeButton: Button = view.findViewById(R.id.remindMeButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coming_soon, parent, false)
        return ComingSoonViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComingSoonViewHolder, position: Int) {
        val comingSoon = comingSoonList[position]
        holder.comingSoonTitle.text = comingSoon.title
        holder.comingSoonDate.text = comingSoon.releaseDate
        holder.comingSoonDescription.text = comingSoon.description
        holder.comingSoonGenres.text = comingSoon.genres

        // Load image
        Glide.with(holder.itemView.context)
            .load(comingSoon.imageUrl)
            .placeholder(R.drawable.backdrop_placeholder)
            .into(holder.comingSoonImage)

        // Set up remind me button
        holder.remindMeButton.setOnClickListener {
            // In a real app, this would set a reminder
            android.widget.Toast.makeText(
                holder.itemView.context,
                "Reminder set for ${comingSoon.title}",
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount() = comingSoonList.size
}