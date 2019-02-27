package com.github.brianbridge.androidviewmodelexample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.brianbridge.androidviewmodelexample.R
import com.github.brianbridge.androidviewmodelexample.model.User
import com.github.brianbridge.androidviewmodelexample.viewmodel.LogViewModel
import com.github.brianbridge.androidviewmodelexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_simple_demo.*

/**
 * Created by Brian Ho on 27/2/2019.
 */
class SimpleDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_demo)

        textView_description.text = "Data will be fetched after ${LOAD_DELAY/1000} second(s)."

        val logViewModel = ViewModelProviders.of(this).get(LogViewModel::class.java)
        logViewModel.formattedLogs.observe(this, Observer {
                logs -> textView_log.text = logs
        })

        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.loadDelay = LOAD_DELAY
        userViewModel.getUsers().observe(this, Observer<List<User>> { users ->
            logViewModel.addLog("Data received processing to display")

            val builder = StringBuilder()
            for (user in users) {
                builder.append("$user\n")
            }

            textView_data.text = builder.toString()

            logViewModel.addLog("Data displayed")
        })

        logViewModel.addLog("Activity created, waiting for the data")
    }

    companion object {
        const val LOAD_DELAY = 5000L
    }
}