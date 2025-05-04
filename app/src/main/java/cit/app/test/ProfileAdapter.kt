package cit.app.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ProfileAdapter(private val profiles: List<Profile>) :
    RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val profileName: TextView = view.findViewById(R.id.profileName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val profile = profiles[position]
        holder.profileName.text = profile.name

        if (profile.imageUrl.isEmpty()) {
            // This is the "Add Profile" item
            holder.profileImage.setImageResource(R.drawable.ic_add_profile)
        } else {
            // Load profile image
            Glide.with(holder.itemView.context)
                .load(profile.imageUrl)
                .placeholder(R.drawable.profile_placeholder)
                .circleCrop()
                .into(holder.profileImage)
        }
    }

    override fun getItemCount() = profiles.size
}