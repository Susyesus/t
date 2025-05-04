package cit.app.test

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val profilesRecyclerView = view.findViewById<RecyclerView>(R.id.profilesRecyclerView)
        val settingsButton = view.findViewById<Button>(R.id.settingsButton)
        val logoutButton = view.findViewById<Button>(R.id.logoutButton)
        val usernameText = view.findViewById<TextView>(R.id.usernameText)
        val emailText = view.findViewById<TextView>(R.id.emailText)

        // Set up user info
        usernameText.text = "John Doe"
        emailText.text = "john.doe@example.com"

        // Set up profiles RecyclerView
        profilesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val profileAdapter = ProfileAdapter(getDummyProfiles())
        profilesRecyclerView.adapter = profileAdapter

        // Set up settings button
        settingsButton.setOnClickListener {
            val intent = Intent(activity, SettingsActivity::class.java)
            startActivity(intent)
        }

        // Set up logout button
        logoutButton.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }
    }

    private fun getDummyProfiles(): List<Profile> {
        return listOf(
            Profile("John", "https://placeholder.com/100x100"),
            Profile("Jane", "https://placeholder.com/100x100"),
            Profile("Kids", "https://placeholder.com/100x100"),
            Profile("Add Profile", "")
        )
    }
}