package com.englishforbusy.android.ui.words

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.englishforbusy.android.R

class WordsFragment : Fragment() {

    companion object {
        fun newInstance() = WordsFragment()
    }

    private lateinit var viewModel: WordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_words, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WordsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}