package com.github.brianbridge.androidviewmodelexample.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.github.brianbridge.androidviewmodelexample.R
import com.github.brianbridge.androidviewmodelexample.viewmodel.SelectorViewModel
import kotlinx.android.synthetic.main.fragment_sync_selector.*

/**
 * Created by Brian Ho on 27/2/2019.
 */
class SyncSelectorFragment : Fragment() {
    private val logTag: String = SyncSelectorFragment::class.java.simpleName

    private lateinit var selectorViewMode: SelectorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectorViewMode = activity?.run {
            ViewModelProviders.of(this).get(SelectorViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        selectorViewMode.status.observe(this, Observer {
            switch1?.isChecked = it.get(1)
            switch2?.isChecked = it.get(2)
            switch3?.isChecked = it.get(3)
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sync_selector, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        switch1.setOnCheckedChangeListener { compoundButton, b ->
            selectorViewMode.setStatus(1, b)
        }
        switch2.setOnCheckedChangeListener { compoundButton, b ->
            selectorViewMode.setStatus(2, b)
        }
        switch3.setOnCheckedChangeListener { compoundButton, b ->
            selectorViewMode.setStatus(3, b)
        }
    }
}