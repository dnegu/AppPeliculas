package com.dnegu.apptemplate.common

import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dnegu.apptemplate.BR
import com.dnegu.apptemplate.R
import com.dnegu.core.movie.Movie

class GenericViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val imageView: ImageView = itemView.findViewById(R.id.imgMovie)

    fun bind(item: Movie) {
        binding.setVariable(BR.obj, item)
        Glide.with(imageView.context)
            .load(item.poster_path)
            .error(R.drawable.ic_logo)
            .into(imageView)
        binding.executePendingBindings()
    }
}