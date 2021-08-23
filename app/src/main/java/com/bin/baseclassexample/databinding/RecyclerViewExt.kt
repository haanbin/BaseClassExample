package com.bin.baseclassexample.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bin.baseclassexample.base.BaseDataBindingAdapter
import java.lang.Exception

@BindingAdapter(
    "bind:items",
    "bind:listener",
    "bind:itemRes"
)
fun RecyclerView.setBaseDataBindingAdapter(
    items: List<Any>?,
    listener: Any?,
    itemRes: Int?
) {
    if (itemRes == null) {
        throw Exception("itemRes is required.")
    }
    val adapter = this.adapter as? BaseDataBindingAdapter
        ?: BaseDataBindingAdapter(itemRes).also {
            it.listener = listener
            this.adapter = it
        }
    adapter.replaceAll(items)
}