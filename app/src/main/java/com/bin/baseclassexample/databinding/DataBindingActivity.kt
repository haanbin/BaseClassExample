package com.bin.baseclassexample.databinding

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bin.baseclassexample.R

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDataBindingBinding
    private val viewModel: DataBindingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        with(binding) {
            vm = viewModel
            listener = viewModel
            lifecycleOwner = this@DataBindingActivity
        }

        viewModel.itemClickEvent.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this, "Click $it", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

interface DataBindingAdapterListener {
    fun onClickItem(string: String)
}