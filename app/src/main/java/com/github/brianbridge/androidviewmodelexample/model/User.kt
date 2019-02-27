package com.github.brianbridge.androidviewmodelexample.model

/**
 * Created by Brian Ho on 22/2/2019.
 */
data class User(val id: String, val name: String) {
    override fun toString(): String {
        return "User(id='$id', name='$name')"
    }
}