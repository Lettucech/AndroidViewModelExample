package com.github.brianbridge.androidviewmodelexample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.brianbridge.androidviewmodelexample.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val tag: String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_simpleDemo.setOnClickListener {
            startActivity(Intent(this, SimpleDemoActivity::class.java))
        }
    }
}
