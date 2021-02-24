package com.englishforbusy.android.ui.add_words

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
import com.englishforbusy.android.data.model.Word
import com.englishforbusy.android.databinding.FragmentAddWordsBinding
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class AddWordsFragment : Fragment() {

    companion object {
        fun newInstance() = AddWordsFragment()
    }

    private val binding: FragmentAddWordsBinding by viewBinding()
    private val viewModel: AddWordsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_words, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.button.setOnClickListener {
            (requireActivity() as MainActivity).list.add(Word(binding.en.text.toString(), binding.ua.text.toString()))
            findNavController().popBackStack()
        }
    }

}