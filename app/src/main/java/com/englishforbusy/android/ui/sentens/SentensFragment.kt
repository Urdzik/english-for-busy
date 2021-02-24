package com.englishforbusy.android.ui.sentens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.englishforbusy.android.R

class SentensFragment : Fragment() {

    companion object {
        fun newInstance() = SentensFragment()
    }

    private lateinit var viewModel: SentensViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sentens, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SentensViewModel::class.java)
        // TODO: Use the ViewModel
    }

}