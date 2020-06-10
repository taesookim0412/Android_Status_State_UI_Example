package com.example.status_statedemo

import android.opengl.Visibility
import android.os.Bundle
import android.os.Looper
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.status_statedemo.databinding.ActivityMainBinding

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val viewModel by viewModels<StateViewModel>()
    val vals = StateVals

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        view.viewModel = viewModel
        view.setLifecycleOwner(this)
        setSupportActionBar(view.toolbar)

        CoroutineScope(Dispatchers.IO).launch{
            val time = System.currentTimeMillis()
            delay(2000)
            runOnUiThread(Runnable{
                viewModel.progress.value[vals.prog] = View.GONE
                viewModel.progress.value[vals.succ] = View.VISIBLE
                viewModel.progressVar.value = View.GONE
                viewModel.success.value = View.VISIBLE
            })
            delay(2000)
            runOnUiThread(Runnable{
                viewModel.progress.value[vals.succ] = View.GONE
                viewModel.progress.value[vals.err] = View.VISIBLE
                viewModel.success.value = View.GONE
                viewModel.error.value = View.VISIBLE
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
