package com.example.myapplication

import android.app.Application
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.quickersilver.themeengine.ThemeEngine
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ThemeEngine.applyToActivities(application)
        setContentView(R.layout.activity_login)
        submit_btn.setOnClickListener(View.OnClickListener {
            Toast.makeText(applicationContext, "clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, sos_homepage::class.java).apply {
                putExtra("value", "passed!")
            }
            startActivity(intent)
        })
        skip_btn.setOnClickListener {
            val intent = Intent(this, sos_homepage::class.java).apply {
                putExtra("value", "passed!")
            }
            startActivity(intent)
        }
    }
}
