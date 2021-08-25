package com.bin.baseclassexample.viewbinding

import android.view.View
import com.bin.baseclassexample.R
import com.bin.baseclassexample.base.BaseViewBindingAdapter
import com.bin.baseclassexample.databinding.ItemViewBindingBinding

class ViewBindingAdapter(private val listener: ViewBindingAdapterListener) :
    BaseViewBindingAdapter<String, ItemViewBindingBinding>(R.layout.item_view_binding) {

    override fun onCreateViewBinding(itemView: View) = ItemViewBindingBinding.bind(itemView)

    override fun onBindView(
        item: String,
        binding: ItemViewBindingBinding,
        adapterPosition: Int
    ) {
        binding.tvPosition.text = adapterPosition.toString()
        binding.tvSimple.text = item

        binding.root.setOnClickListener {
            listener.onClickItem(item)
        }
    }
}

fun interface ViewBindingAdapterListener {
    fun onClickItem(string: String)
}