package com.example.quickwin
import android.content.Intent
import android.widget.Toast
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmailAddress: EditText
    private lateinit var etPassword: EditText
    private lateinit var confirmPassword: EditText
    val btnSignUp = findViewById<Button>(R.id.btnLogIn)

   // var etEmailAddress: EditText = findViewById(R.id.etEmailAddress)
   // var etPassword: EditText = findViewById(R.id.etPassword)
    //var confirmPassword: EditText = findViewById(R.id.confirmPassword)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        auth = FirebaseAuth.getInstance()

        btnSignUp.setOnClickListener {
            signupUser()

        }
    }

        private fun signupUser() {
            val email = etEmailAddress.text.toString()
            val password = etPassword.text.toString()
            val confirmPassword = confirmPassword.text.toString()

            // TODO: Implement user authentication logic
            //empty Email and password
            if (email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                Toast.makeText(this, "Email and password can't be blank", Toast.LENGTH_LONG).show()
                return
            }

            if (password != confirmPassword){
                Toast.makeText(this, "password and confirm Password do not match", Toast.LENGTH_SHORT)
                    .show()
            return

        }
            auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    val user = auth.currentUser
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                    // Navigate to the next activity
                } else {
                    Toast.makeText(this, "Login failed.", Toast.LENGTH_SHORT).show()
                }      //code

            }

    }
    }



























