package cit.app.test

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val signupText = findViewById<TextView>(R.id.signupText)

        loginButton.setOnClickListener {
            // Validate login credentials
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // In a real app, you would validate against a backend
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Show error
                if (email.isEmpty()) {
                    emailEditText.error = "Email is required"
                }
                if (password.isEmpty()) {
                    passwordEditText.error = "Password is required"
                }
            }
        }

        signupText.setOnClickListener {
            // Navigate to signup screen
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }
}