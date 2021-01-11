package com.ssharanyab.coinedone

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
//import android.support.wearable.watchface.accessibility.AccessibilityUtils
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.AccessibilityServiceInfo
import android.content.Context

import com.yazdanmanesh.url_resteriction.AccessibilityUtils
import android.provider.Settings
import android.view.accessibility.AccessibilityManager
import android.widget.Toast

import com.yazdanmanesh.url_resteriction.MyAccessibilityService

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        val actionBar: ActionBar? = supportActionBar
        if (actionBar != null) {
            actionBar.hide()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myService = AccessibilityUtils.Builder()
        val google = AccessibilityUtils.Builder()

        myService.setRedirectTo("http://www.404.net")


//        val myService = AccessibilityUtils.Builder()

        if (!isAccessibilityServiceEnabled(
                this,MyAccessibilityService::class.java
            )){
            startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
        }
        if(isAccessibilityServiceEnabled(this@MainActivity,
                MyAccessibilityService::class.java)){
            myService.setMyRestrictedAddress("www.facebook.com")
            myService.setRedirectTo("http://www.404.net")
            myService.build()
            myService.setMyRestrictedAddress("facebook.com")
            myService.setRedirectTo("http://www.404.net")
            myService.build()
            myService.setMyRestrictedAddress("m.facebook.com")
            myService.setRedirectTo("http://www.404.net")
            myService.build()

            google.setMyRestrictedAddress("google.com")
            google.setRedirectTo("http://www.404.net")
            google.build()
            Toast.makeText(this,"Done",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
        }
        val button = findViewById<ImageButton>(R.id.imageButton)
        button.setOnClickListener{
            val Intent = Intent(this, SceenActivity::class.java)
            startActivity(Intent)
        }
    }
    fun isAccessibilityServiceEnabled(
        context: Context,
        service: Class<out AccessibilityService?>
    ): Boolean {
        val am = context.getSystemService(ACCESSIBILITY_SERVICE) as AccessibilityManager
        val enabledServices =
            am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_ALL_MASK)
        for (enabledService in enabledServices) {
            val enabledServiceInfo = enabledService.resolveInfo.serviceInfo
            if (enabledServiceInfo.packageName == context.packageName && enabledServiceInfo.name == service.name) return true
        }
        return false
    }
}