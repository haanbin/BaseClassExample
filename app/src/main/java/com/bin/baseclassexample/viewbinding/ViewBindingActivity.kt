package com.bin.baseclassexample.viewbinding

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bin.baseclassexample.R
import com.bin.baseclassexample.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity(R.layout.activity_view_binding),
    ViewBindingAdapterListener {

    private lateinit var binding: ActivityViewBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ViewBindingAdapter(this)
        binding.rvViewBinding.adapter = adapter
        adapter.replaceAll(arrayListOf("가", "나", "다", "라", "마", "바"))
    }

    override fun onClickItem(string: String) {
        Toast.makeText(this, "Click $string", Toast.LENGTH_SHORT).show()
    }
}