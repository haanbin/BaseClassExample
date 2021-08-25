package com.bin.baseclassexample.viewbinding

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bin.baseclassexample.R
import com.bin.baseclassexample.base.BaseViewBindingAdapterTwo
import com.bin.baseclassexample.databinding.ItemViewBindingBinding

class ViewBindingAdapterTwo(private val listener: ViewBindingAdapterTwoListener) :
    BaseViewBindingAdapterTwo<String, ItemViewBindingBinding>(R.layout.item_view_binding) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewBindingViewHolderTwo<String, ItemViewBindingBinding> {
        return ViewBindingViewHolderTwo(parent, viewType, listener)
    }

    class ViewBindingViewHolderTwo(
        parent: ViewGroup,
        @LayoutRes
        layoutRes: Int,
        private val listener: ViewBindingAdapterTwoListener
    ) : BaseViewBindingViewHolderTwo<String, ItemViewBindingBinding>(parent, layoutRes) {

        override val viewBinding: ItemViewBindingBinding = ItemViewBindingBinding.bind(itemView)
        private var item: String? = null

        init {
            viewBinding.root.setOnClickListener {
                item?.let {
                    listener.onClickItem(it)
                }
            }
        }

        override fun bindView(item: String) {
            this.item = item

            viewBinding.tvPosition.text = adapterPosition.toString()
            viewBinding.tvSimple.text = item
        }
    }
}

interface ViewBindingAdapterTwoListener {
    fun onClickItem(string: String)
}