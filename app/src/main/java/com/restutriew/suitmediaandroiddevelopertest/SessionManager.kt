package com.restutriew.suitmediaandroiddevelopertest

import android.content.Context
import android.content.SharedPreferences

class SessionManager {
    var pref: SharedPreferences
    var edior: SharedPreferences.Editor
    var context: Context
    var PRIVATE_MODE: Int = 0

    constructor(context: Context) {
        this.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        edior = pref.edit()
    }

    companion object {
        val PREF_NAME: String = "UserData"
        val KEY_NAME: String = "name"
        val KEY_GUEST: String = "guest"

    }

    fun createSessionName(name: String) {
        edior.putString(KEY_NAME, name)
        edior.commit()
    }

    fun createSessionGuest(guest: String) {
        edior.putString(KEY_GUEST, guest)
        edior.commit()
    }

    fun getUserDetails(): HashMap<String, String> {
        var user: Map<String, String> = HashMap<String, String>()
        (user as HashMap).put(KEY_NAME, pref.getString(KEY_NAME, null).toString())
        (user as HashMap).put(KEY_GUEST, pref.getString(KEY_GUEST, null).toString())
        return user
    }


}