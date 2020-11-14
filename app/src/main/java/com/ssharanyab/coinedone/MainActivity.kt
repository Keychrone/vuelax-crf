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
   