package com.bin.baseclassexample.viewbinding

import android.widget.Toast
import com.bin.baseclassexample.base.BaseViewBindingActivity
import com.bin.baseclassexample.databinding.ActivityViewBindingBinding

class ViewBindingActivity :
    BaseViewBindingActivity<ActivityViewBindingBinding>({ ActivityViewBindingBinding.inflate(it) }),
    ViewBindingAdapterListener {

    override fun start() {
        val adapter = ViewBindingAdapter(this)
        viewBinding.rvViewBinding.adapter = adapter
        adapter.replaceAll(arrayListOf("가", "나", "다", "라", "마", "바"))

        /*val simpleAdapter = SimpleAdapter {
            Toast.makeText(this, "Click $it", Toast.LENGTH_SHORT).show()
        }
        viewBinding.rvViewBinding.adapter = simpleAdapter
        simpleAdapter.replaceAll(arrayListOf("가", "나", "다", "라", "마", "바"))*/
    }

    override fun onClickItem(string: String) {
        Toast.makeText(this, "Click $string", Toast.LENGTH_SHORT).show()
    }
}