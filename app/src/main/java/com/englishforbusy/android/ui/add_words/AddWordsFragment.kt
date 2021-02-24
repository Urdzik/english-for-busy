package com.englishforbusy.android.ui.add_words

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.englishforbusy.android.R

class AddWordsFragment : Fragment() {

    companion object {
        fun newInstance() = AddWordsFragment()
    }

    private lateinit var viewModel: AddWordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_words, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AddWordsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}