package com.phonefreework.util

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.regex.Pattern

class Validation {

    fun isEmailValid(email: String, editText: EditText): Boolean {
        if (TextUtils.isEmpty(email)){
            editText.requestFocus()
            editText.error = "Enter your email id"
            return false
        }
        else if (!email.matches("[a-zA-Z0-9._-]+[_A-Za-z0-9-]+@[a-z]+\\.[a-z]+".toRegex())){
            editText.requestFocus()
            editText.error = "Enter your valid email id"
            return false
        }
        return true
    }

    fun isPassword(password: String, editText: EditText): Boolean {
        if (TextUtils.isEmpty(password)){
            editText.requestFocus()
            editText.error = "Enter your password"
            return false
        }
        return true
    }

    fun isPasswordMatch(password: String, password2: String, editText: EditText): Boolean {
        if (!password.equals(password2)){
            editText.requestFocus()
            editText.error = "Password should be same...!!!"
            return false
        }
        return true
    }

}