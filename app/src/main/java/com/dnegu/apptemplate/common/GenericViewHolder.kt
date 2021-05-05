package com.dnegu.apptemplate.common

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dnegu.apptemplate.BR

class GenericViewHolder<T>(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: T) {
        binding.setVariable(BR.obj, item)
        binding.executePendingBindings()
    }
}