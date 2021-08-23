package com.bin.baseclassexample.databinding

import android.widget.Toast
import androidx.activity.viewModels
import com.bin.baseclassexample.R
import com.bin.baseclassexample.base.BaseDataBindingActivity

class DataBindingActivity :
    BaseDataBindingActivity<ActivityDataBindingBinding, DataBindingViewModel>(R.layout.activity_data_binding) {

    override val viewModel: DataBindingViewModel by viewModels()

    override fun start() {
        binding.listener = viewModel

        viewModel.itemClickEvent.observe(this, { event ->
            event.getContentIfNotHandled()?.let {
                Toast.makeText(this, "Click $it", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
