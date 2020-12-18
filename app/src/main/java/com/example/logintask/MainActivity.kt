package com.example.logintask

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.phonefreework.util.Validation
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //check if device is tablet
        if (!isTablet(this)){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        //login validations
        button.setOnClickListener {
            if (Validation().isEmailValid(editTextTextEmailAddress.text.toString(), editTextTextEmailAddress)
                && Validation().isPassword(editTextTextPassword.text.toString(), editTextTextPassword)
                && Validation().isPassword(editTextTextPassword2.text.toString(), editTextTextPassword2)
                && Validation().isPasswordMatch(editTextTextPassword.text.toString(), editTextTextPassword2.text.toString(),
                    editTextTextPassword2)
            ){
                AlertDialog()
            }
        }

    }

    //check if device is tablet
    fun isTablet(context: Context): Boolean {
        return ((context.getResources().getConfiguration().screenLayout
                and Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE)
    }


    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate if the process is
        // killed and restarted.
        savedInstanceState.putString("email", editTextTextEmailAddress.text.toString())
        // etc.
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val myString = savedInstanceState.getString("email")
        editTextTextEmailAddress.setText(myString)
    }


    fun AlertDialog(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage(resources.getString(R.string.txt_dialog_message) + editTextTextEmailAddress)
        // Set Alert Title
        builder.setTitle(resources.getString(R.string.txt_dialog_message_title))
        builder.setCancelable(false)
        builder.setPositiveButton(
            resources.getString(R.string.txt_dialog_yes),
                DialogInterface.OnClickListener { dialog, which -> // When the user click yes button
                    // then app will close
                    finish()
                })
        builder.setNegativeButton(
            resources.getString(R.string.txt_dialog_no),
                DialogInterface.OnClickListener { dialog, which -> // If user click no
                    // then dialog box is canceled.
                    dialog.cancel()
                })
        // Create the Alert dialog
        val alertDialog: AlertDialog = builder.create()
        // Show the Alert Dialog box
        alertDialog.show()
    }




}