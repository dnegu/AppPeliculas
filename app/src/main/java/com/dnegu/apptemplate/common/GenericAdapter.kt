package com.dnegu.apptemplate.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dnegu.core.common.TypeFactory
import com.dnegu.core.common.Visitable

class GenericAdapter : RecyclerView.Adapter<GenericViewHolder<Visitable>>() {

    private val typeFactory: TypeFactory = TypeFactoryImpl()
    private var items: List<Visitable> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GenericViewHolder<Visitable> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater, viewType, parent, false)
        return GenericViewHolder(binding)
    }

    override fun getItemViewType(position: Int): Int {
        return items[position].type(typeFactory)
    }

    override fun onBindViewHolder(holder: GenericViewHolder<Visitable>, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(items: List<Visitable>) {
        this.items = items
        notifyDataSetChanged()
    }
}