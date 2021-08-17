package com.bin.baseclassexample.viewbinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bin.baseclassexample.R
import com.bin.baseclassexample.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity(R.layout.activity_view_binding) {

    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewBindingAdapter()
        binding.rvViewBinding.adapter = adapter
        adapter.replaceAll(arrayListOf("1", "2", "3", "4"))
    }
}