package com.bin.baseclassexample.viewbinding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.bin.baseclassexample.R
import com.bin.baseclassexample.databinding.ItemSimpleBinding

class SimpleAdapter(private val listener: SimpleAdapterListener) :
    RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    private val items = arrayListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SimpleViewHolder(parent, layoutRes = viewType, listener)

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.onBindView(items[position])
    }

    override fun getItemCount() = items.size

    override fun getItemViewType(position: Int) = R.layout.item_simple

    fun replaceAll(items: List<String>?) {
        this.items.run {
            clear()
            items?.let {
                addAll(it)
            }
        }
        notifyDataSetChanged()
    }

    class SimpleViewHolder(
        parent: ViewGroup,
        @LayoutRes
        layoutRes: Int,
        private val listener: SimpleAdapterListener
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
    ) {

        private val viewBinding = ItemSimpleBinding.bind(itemView)
        private var string: String? = null

        init {
            viewBinding.root.setOnClickListener {
                string?.let {
                    listener.onClickItem(it)
                }
            }
        }

        fun onBindView(string: String) {
            this.string = string
            viewBinding.tvPosition.text = adapterPosition.toString()
            viewBinding.tvSimple.text = string
        }
    }
}

fun interface SimpleAdapterListener {
    fun onClickItem(string: String)
}