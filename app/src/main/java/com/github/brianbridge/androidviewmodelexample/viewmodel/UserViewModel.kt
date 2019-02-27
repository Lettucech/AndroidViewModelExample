package com.github.brianbridge.androidviewmodelexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.brianbridge.androidviewmodelexample.model.User
import kotlinx.coroutines.*

/**
 * Created by Brian Ho on 22/2/2019.
 */
class UserViewModel : ViewModel() {
    private val TAG: String = UserViewModel::class.java.simpleName
    var loadDelay = 5000L

    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUsers(): LiveData<List<User>> {
        return users
    }

    private fun loadUsers() = GlobalScope.launch {
        val loader = async {
            delay(loadDelay)
            return@async listOf(
                User("001", "Lee Chi Nan"),
                User("002", "Chan Tai Man"),
                User("003", "Cheung Chung Yin"),
                User("004", "Oh My God")
            )
        }
        users.postValue(loader.await())
    }
}