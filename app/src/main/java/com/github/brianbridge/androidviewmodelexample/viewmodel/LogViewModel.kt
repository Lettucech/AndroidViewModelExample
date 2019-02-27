package com.github.brianbridge.androidviewmodelexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by Brian Ho on 27/2/2019.
 */
class LogViewModel : ViewModel() {
    private val logs: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }

    val formattedLogs: LiveData<String> = Transformations.map(logs) {
        val builder = StringBuilder()

        for (log in it) {
            if (!builder.isEmpty()) {
                builder.append("\n")
            }
            builder.append(log)
        }

        builder.toString()
    }

    fun addLog(log: String) {
        logs.value = logs.value?.let {
            val tempList = it.toMutableList()
            if (tempList.size >= 10) {
                tempList.removeAt(0)
            }
            tempList.add(log)
            tempList
        } ?: listOf(log)
    }
}