package com.github.brianbridge.androidviewmodelexample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.brianbridge.androidviewmodelexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_simpleDemo.setOnClickListener {
            startActivity(Intent(this, SimpleDemoActivity::class.java))
        }
        btn_syncSelectorDemo.setOnClickListener {
            startActivity(Intent(this, SyncSelectorActivity::class.java))
        }
    }
}
