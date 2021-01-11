
package com.ssharanyab.coinedone

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar

class SceenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sceen)

        val sw1 = findViewById<Switch>(R.id.switch1)
        sw1?.setOnCheckedChangeListener { _, isChecked ->
            val textDetails = findViewById<TextView>(R.id.details)
            val text1 = findViewById<TextView>(R.id.blacklist)
            val text2 = findViewById<TextView>(R.id.whitelist)
            if (isChecked){
                text1.setTypeface(null,Typeface.BOLD)
                text2.setTypeface(null, Typeface.NORMAL)
                textDetails.text="In blacklist mode, the websites in the list are blocked but all other websites are allowed. "

            }
            else{
                text2.setTypeface(null,Typeface.BOLD)
                text1.setTypeface(null,Typeface.NORMAL)
                textDetails.text="In whitelist mode, the websites in the list are allowed but all other websites are blocked. "

            }

        }
    }
}