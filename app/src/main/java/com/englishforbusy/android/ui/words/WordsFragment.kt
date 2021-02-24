package com.englishforbusy.android.ui.words

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.MainActivity
import com.englishforbusy.android.R
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.databinding.FragmentWordsBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class WordsFragment : Fragment() {

    companion object {
        fun newInstance() = WordsFragment()
    }

    private val binding: FragmentWordsBinding by viewBinding()
    private val viewModel: WordsViewModel by viewModels()

    private val adapter = WordsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_words, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerView.adapter = adapter

        adapter.submitList((requireActivity() as MainActivity).list)

        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(WordsFragmentDirections.actionWordsFragmentToAddWordsFragment())
        }
    }

}