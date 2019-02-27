package com.github.brianbridge.androidviewmodelexample.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.brianbridge.androidviewmodelexample.R
import com.github.brianbridge.androidviewmodelexample.fragment.SyncSelectorFragment

/**
 * Created by Brian Ho on 27/2/2019.
 */
class SyncSelectorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sync_selector)

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_fragment1, SyncSelectorFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_fragment2, SyncSelectorFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_fragment3, SyncSelectorFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout_fragment4, SyncSelectorFragment())
            .commit()
    }
}