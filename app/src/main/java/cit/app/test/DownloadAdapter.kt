package cit.app.test


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class DownloadAdapter(private val downloads: List<Download>) :
    RecyclerView.Adapter<DownloadAdapter.DownloadViewHolder>() {

    class DownloadViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val downloadImage: ImageView = view.findViewById(R.id.downloadImage)
        val downloadTitle: TextView = view.findViewById(R.id.downloadTitle)
        val downloadEpisode: TextView = view.findViewById(R.id.downloadEpisode)
        val downloadSize: TextView = view.findViewById(R.id.downloadSize)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_download, parent, false)
        return DownloadViewHolder(view)
    }

    override fun onBindViewHolder(holder: DownloadViewHolder, position: Int) {
        val download = downloads[position]
        holder.downloadTitle.text = download.title
        holder.downloadEpisode.text = download.episodeInfo
        holder.downloadSize.text = download.size

        // Load image
        Glide.with(holder.itemView.context)
            .load(download.imageUrl)
            .placeholder(R.drawable.movie_placeholder)
            .into(holder.downloadImage)
    }

    override fun getItemCount() = downloads.size
}