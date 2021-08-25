package com.bin.baseclassexample.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingAdapterTwo<ITEM : Any, VB : ViewBinding>(
    @LayoutRes private val layoutResId: Int
) : RecyclerView.Adapter<BaseViewBindingAdapterTwo.BaseViewBindingViewHolderTwo<ITEM, VB>>() {

    private val items = arrayListOf<ITEM>()

    override fun onBindViewHolder(holder: BaseViewBindingViewHolderTwo<ITEM, VB>, position: Int) {
        holder.onBindView(items[position])
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

    abstract class BaseViewBindingViewHolderTwo<ITEM : Any, VB : ViewBinding>(
        parent: ViewGroup,
        @LayoutRes
        layoutRes: Int
    ) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
        ) {

        abstract val viewBinding: VB
        abstract fun onBindView(item: ITEM)
    }
}