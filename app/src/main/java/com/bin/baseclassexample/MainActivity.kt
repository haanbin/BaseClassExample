package com.bin.baseclassexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.bin.baseclassexample.databinding.DataBindingActivity
import com.bin.baseclassexample.viewbinding.ViewBindingActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    fun onViewBindingAdapterClick(v: View) {
        startActivity(Intent(this, ViewBindingActivity::class.java))
    }

    fun onDataBindingAdapterClick(v: View) {
        startActivity(Intent(this, DataBindingActivity::class.java))
    }
}