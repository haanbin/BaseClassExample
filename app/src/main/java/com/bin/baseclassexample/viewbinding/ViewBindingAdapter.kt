package com.bin.baseclassexample.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bin.baseclassexample.R
import com.bin.baseclassexample.base.BaseViewBindingAdapter
import com.bin.baseclassexample.databinding.ItemViewBindingBinding

class ViewBindingAdapter :
    BaseViewBindingAdapter<String, ItemViewBindingBinding>(R.layout.item_view_binding) {

    override val bindView: (item: String, binding: ItemViewBindingBinding) -> Unit = ::bindViewHolder

    override fun onCreateViewBinding(parent: ViewGroup, viewType: Int) =
        ItemViewBindingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    private fun bindViewHolder(item: String, binding: ItemViewBindingBinding) {
        binding.tvSimple.text = item
    }
}