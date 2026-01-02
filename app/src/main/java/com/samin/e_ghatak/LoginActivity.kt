package com.samin.e_ghatak

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var emailedittext: EditText? = null
    private var passwordedittext: EditText? = null
    private var button: Button? = null
    private var firebaseUser: FirebaseUser? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth = FirebaseAuth.getInstance()
        emailedittext = findViewById(R.id.editTextTextEmailAddress)
        passwordedittext = findViewById(R.id.editTextTextPassword)
        button = findViewById(R.id.loginbutton)
        button?.setOnClickListener(View.OnClickListener {
            val email: String = this.emailedittext?.getText().toString().trim { it <= ' ' }
            val password = this.passwordedittext?.getText().toString()
            if (email.isEmpty()) {
                this.emailedittext?.setError("Enter an email address")
                emailedittext?.requestFocus()
                return@OnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailedittext?.setError("Enter a valid email address")
                emailedittext?.requestFocus()
                return@OnClickListener
            }
            if (password.isEmpty()) {
                passwordedittext?.setError("Enter password")
                passwordedittext?.requestFocus()
                return@OnClickListener
            }
            if (password.length < 6) {
                passwordedittext?.setError("Minimum length is 6 digits")
                passwordedittext?.requestFocus()
                return@OnClickListener
            }

            //progressBar.setVisibility(View.VISIBLE);
            val progressDialog = ProgressDialog(this@LoginActivity)
            progressDialog.setMessage("Logging in")
            progressDialog.show()
            mAuth!!.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task -> //progressBar.setVisibility(View.GONE);
                        progressDialog.dismiss()
                        if (task.isSuccessful) {
                            val intent = Intent(this@LoginActivity, ProfileActivity::class.java)
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                            finish()
                        } else Toast.makeText(this@LoginActivity, "Authentication failed", Toast.LENGTH_SHORT).show()
                    }
        })
    }

    public override fun onStart() {
        super.onStart()
        firebaseUser = FirebaseAuth.getInstance().currentUser
        if (firebaseUser != null) {
            val intent = Intent(this@LoginActivity, ChooseActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun GoToReg(view: View?) {
        val intent = Intent(this@LoginActivity, RegisterActvity::class.java)
        startActivity(intent)
        finish()
    }
}