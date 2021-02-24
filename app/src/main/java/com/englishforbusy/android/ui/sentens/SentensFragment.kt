package com.englishforbusy.android.ui.sentens

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.R
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.databinding.FragmentSentensBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class SentensFragment : Fragment() {

    companion object {
        fun newInstance() = SentensFragment()
    }

    private val binding: FragmentSentensBinding by viewBinding()
    private val viewModel: SentensViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sentens, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}