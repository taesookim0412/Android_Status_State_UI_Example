package com.example.status_statedemo

import android.opengl.Visibility
import android.os.Bundle
import android.os.Looper
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        CoroutineScope(Dispatchers.IO).launch{
            val time = System.currentTimeMillis()
            delay(5000)
            runOnUiThread(Runnable{
                progress_circular.visibility = View.GONE
                progress_Done.visibility = View.VISIBLE
            })
            delay(5000)
            runOnUiThread(Runnable{
                progress_Done.visibility = View.GONE
                progress_Error.visibility = View.VISIBLE
            })
            println("Triggered after ${System.currentTimeMillis() - time } ms")


        }

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
