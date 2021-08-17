package com.bin.baseclassexample.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingAdapter<ITEM, VB : ViewBinding>(
    @LayoutRes private val layoutResId: Int
) : RecyclerView.Adapter<BaseViewBindingAdapter.BaseViewBindingViewHolder<ITEM, VB>>() {

    abstract val bindView: (item: ITEM, binding: VB) -> Unit
    abstract fun onCreateViewBinding(
        parent: ViewGroup,
        viewType: Int
    ): VB

    private val items = arrayListOf<ITEM>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewBindingViewHolder<ITEM, VB> {
        return BaseViewBindingViewHolder(
            onCreateViewBinding(parent, viewType), bindView
        )
    }

    override fun onBindViewHolder(holder: BaseViewBindingViewHolder<ITEM, VB>, position: Int) {
        holder.bindViewHolder(items[position])
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        return layoutResId
    }

    open fun replaceAll(items: List<ITEM>?) {
        this.items.run {
            clear()
            items?.let {
                addAll(it)
            }
        }
        notifyDataSetChanged()
    }

    class BaseViewBindingViewHolder<ITEM, VB : ViewBinding>(
        private val viewBinding: VB,
        private val bindView: (item: ITEM, binding: VB) -> Unit
    ) : RecyclerView.ViewHolder(viewBinding.root) {

        fun bindViewHolder(item: ITEM) {
            bindView(item, viewBinding)
        }
    }
}