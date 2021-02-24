package com.englishforbusy.android.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.englishforbusy.android.R
import com.englishforbusy.android.data.model.Word
import com.englishforbusy.android.databinding.ItemWordsBinding

class WordsAdapter: ListAdapter<Word, WordsAdapter.ViewHolder>(DiffUtils()) {



    inner class ViewHolder(private val binding: ItemWordsBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(data: Word){
            binding.en.text = data.en
            binding.ua.text = data.ua
        }
    }

    class DiffUtils: DiffUtil.ItemCallback<Word>(){
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.en == newItem.en
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemWordsBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.item_words, parent, false)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}