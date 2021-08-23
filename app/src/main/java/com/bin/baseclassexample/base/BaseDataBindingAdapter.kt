package com.bin.baseclassexample.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bin.baseclassexample.BR

open class BaseDataBindingAdapter(
    @LayoutRes
    private val layoutRes: Int
) :
    RecyclerView.Adapter<BaseDataBindingAdapter.BaseDataBindingViewHolder>() {

    var listener: Any? = null
    private val items = arrayListOf<Any?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BaseDataBindingViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: BaseDataBindingViewHolder, position: Int) {
        holder.onBindViewHolder(items[position], listener)
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int): Int = layoutRes

    open fun replaceAll(items: List<Any>?) {
        this.items.run {
            clear()
            items?.let {
                addAll(it)
            }
        }
        notifyDataSetChanged()
    }

    open class BaseDataBindingViewHolder(parent: ViewGroup, viewType: Int) :
        RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        ) {

        private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

        open fun onBindViewHolder(item: Any?, listener: Any?) {
            binding.run {
                setVariable(BR.item, item)
                setVariable(BR.listener, listener)
                setVariable(BR.adapterPosition, adapterPosition)
            }
        }
    }
}