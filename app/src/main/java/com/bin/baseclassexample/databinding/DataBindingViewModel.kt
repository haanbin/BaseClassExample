package com.bin.baseclassexample.databinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bin.baseclassexample.Event
import com.bin.baseclassexample.base.BaseViewModel

class DataBindingViewModel : BaseViewModel(), DataBindingAdapterListener {

    private val _items = MutableLiveData<List<String>>(arrayListOf("가", "나", "다", "라", "마", "바"))
    val items: LiveData<List<String>> = _items

    private val _itemClickEvent = MutableLiveData<Event<String>>()
    val itemClickEvent: LiveData<Event<String>> = _itemClickEvent

    fun onTestClick() {
        _items.value = arrayListOf("가", "나", "다")
    }

    override fun onClickItem(string: String) {
        _itemClickEvent.value = Event(string)
    }
}

interface DataBindingAdapterListener {
    fun onClickItem(string: String)
}