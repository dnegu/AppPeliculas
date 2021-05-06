package com.dnegu.apptemplate.common

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.dnegu.apptemplate.R
import com.dnegu.core.common.TypeFactory
import com.dnegu.core.common.Visitable
import com.squareup.picasso.Picasso

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
    @BindingAdapter("app:image_url")
    fun loadImage(view: ImageView, logoUrl: String?) {
        if (logoUrl == null) {
            view.setImageResource(R.drawable.ic_logo)
        } else {
            Picasso.with(view.getContext())
                    .load(logoUrl)
                    .placeholder(R.drawable.ic_logo)
                    .into(view)
        }
    }
}