package com.example.easyvr.features.tour.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.easyvr.R
import com.example.easyvr.databinding.ItemFilterListBottomSheetBinding
import com.example.easyvr.model.Filter

class FilterAdapter: ListAdapter<Filter, FilterAdapter.FilterViewHolder>(ItemCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FilterViewHolder(ItemFilterListBottomSheetBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class FilterViewHolder internal constructor(val binding: ItemFilterListBottomSheetBinding) :
        RecyclerView.ViewHolder( binding.root) {

        fun bind(filter: Filter){
            binding.filterNameTextView.text = filter.name
            Glide.with(itemView.context).load(filter.image).into(binding.filterImageTextView)
        }
    }



}

class ItemCallback: DiffUtil.ItemCallback<Filter>(){
    override fun areItemsTheSame(oldItem: Filter, newItem: Filter): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: Filter, newItem: Filter): Boolean {
        return oldItem == newItem
    }

}