package com.bin.baseclassexample.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bin.baseclassexample.R
import com.bin.baseclassexample.base.BaseViewBindingAdapter
import com.bin.baseclassexample.databinding.ItemViewBindingBinding

class ViewBindingAdapter(private val listener: ViewBindingAdapterListener) :
    BaseViewBindingAdapter<String, ItemViewBindingBinding>(R.layout.item_view_binding) {

    override val bindViewHolder: (item: String, binding: ItemViewBindingBinding, adapterPosition: Int) -> Unit =
        ::bindViewHolder

    override fun onCreateViewBinding(parent: ViewGroup, viewType: Int) =
        ItemViewBindingBinding.inflate(LayoutInflater.from(parent.context), parent, false)

    private fun bindViewHolder(
        item: String,
        binding: ItemViewBindingBinding,
        adapterPosition: Int
    ) {
        binding.tvPosition.text = adapterPosition.toString()
        binding.tvSimple.text = item

        binding.tvPosition.setOnClickListener {
            listener.onClickItem(adapterPosition.toString())
        }
        binding.tvSimple.setOnClickListener {
            listener.onClickItem(item)
        }
    }
}

interface ViewBindingAdapterListener {
    fun onClickItem(string: String)
}