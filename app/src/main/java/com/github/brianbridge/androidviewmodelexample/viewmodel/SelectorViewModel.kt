package com.github.brianbridge.androidviewmodelexample.viewmodel

import android.util.SparseBooleanArray
import androidx.core.util.set
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Brian Ho on 27/2/2019.
 */
class SelectorViewModel : ViewModel() {
    val state: MutableLiveData<SparseBooleanArray> by lazy {
        MutableLiveData<SparseBooleanArray>()
    }

    fun setStatus(index: Int, checked: Boolean) {
        state.value = state.value?.also {
            it[index] = checked
        } ?: SparseBooleanArray().also { it[index] = checked }
    }
}