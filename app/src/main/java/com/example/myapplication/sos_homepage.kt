package com.example.myapplication

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.myapplication.sidebar.*
import kotlinx.android.synthetic.main.main_content.*
import kotlinx.android.synthetic.main.sos_homepage.*

class sos_homepage:AppCompatActivity() {
    private lateinit var aB : ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sos_homepage)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val msg = intent.getStringExtra("value")
        Toast.makeText(applicationContext, msg.toString(), Toast.LENGTH_SHORT).show()

        sos_btn.setOnClickListener(object : DoubleClickListener() {
                override fun onDoubleClick(v: View?) {
                    Toast.makeText(applicationContext, "Double Click", Toast.LENGTH_SHORT).show()
                }
            })
        aB = ActionBarDrawerToggle(this,drawer,R.string.open,R.string.close)
        drawer.addDrawerListener(aB)
        aB.syncState();
        // drawer.openDrawer(GravityCompat.START)
        nav_menu.setNavigationItemSelectedListener {
            main_frame.visibility = View.INVISIBLE
            sos_btn.visibility = View.INVISIBLE
            when (it.itemId) {
                R.id.profile -> {
                    Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_main,Profile()).commit()
                    true
                }
               /* R.id.Em_con -> {
                    Toast.makeText(applicationContext, "Emergency contacts", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_main,Em_con()).commit()
                    true
                }*/
                R.id.rec_alert -> {
                    Toast.makeText(applicationContext, "recent alerts", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_main,recent_alert()).commit()
                    true
                }
                R.id.helpdesk -> {
                    Toast.makeText(applicationContext, "helpdesk", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_main,helpdesk()).commit()
                    true
                }
                R.id.about_us -> {
                    Toast.makeText(applicationContext, "about_us", Toast.LENGTH_SHORT).show()
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_main,aboutus()).commit()
                    true
                }
                else -> false
            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }
        main_frame.visibility = View.VISIBLE
        sos_btn.visibility = View.VISIBLE
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (aB.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item)
    }

    abstract class DoubleClickListener : View.OnClickListener {
        var lastClickTime: Long = 0
        override fun onClick(v: View?) {
            val clickTime = System.currentTimeMillis()
            if (clickTime - lastClickTime < DOUBLE_CLICK_TIME_DELTA) {
                onDoubleClick(v)
            }
            lastClickTime = clickTime
        }

        abstract fun onDoubleClick(v: View?)
        companion object {
            private const val DOUBLE_CLICK_TIME_DELTA: Long = 900 //milliseconds
        }
    }
}