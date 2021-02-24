package com.englishforbusy.android.ui.trenings

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.englishforbusy.android.R

class TreningsFragment : Fragment() {

    companion object {
        fun newInstance() = TreningsFragment()
    }

    private lateinit var viewModel: TreningsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.trenings_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TreningsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}