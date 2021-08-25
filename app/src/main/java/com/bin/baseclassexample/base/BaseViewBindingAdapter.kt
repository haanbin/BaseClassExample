package com.bin.baseclassexample.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseViewBindingAdapter<ITEM : Any, VB : ViewBinding>(
    @LayoutRes private val layoutResId: Int
) : RecyclerView.Adapter<BaseViewBindingAdapter.BaseViewBindingViewHolder<ITEM, VB>>() {

    abstract fun onCreateViewBinding(itemView: View): VB
    abstract fun onBindView(item: ITEM, binding: VB, adapterPosition: Int)

    private val items = arrayListOf<ITEM>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewBindingViewHolder<ITEM, VB> {
        return object : BaseViewBindingViewHolder<ITEM, VB>(parent, viewType) {

            override val viewBinding: VB = onCreateViewBinding(itemView)

            override fun onBindView(item: ITEM) =
                onBindView(item, viewBinding, adapterPosition)
        }
    }

    override fun onBindViewHolder(holder: BaseViewBindingViewHolder<ITEM, VB>, position: Int) {
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

    abstract class BaseViewBindingViewHolder<ITEM : Any, VB : ViewBinding>(
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