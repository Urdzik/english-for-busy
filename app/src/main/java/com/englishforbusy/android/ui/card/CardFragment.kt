package com.englishforbusy.android.ui.card

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
import com.englishforbusy.android.databinding.FragmentCardBinding
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class CardFragment : Fragment() {

    companion object {
        fun newInstance() = CardFragment()
    }

    private val binding: FragmentCardBinding by viewBinding()
    private val viewModel: CardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}