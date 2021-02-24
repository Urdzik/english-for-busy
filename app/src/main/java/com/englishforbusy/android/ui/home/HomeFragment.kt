package com.englishforbusy.android.ui.home

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
import com.englishforbusy.android.databinding.FragmentHomeBinding
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.cardView2.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToWordsFragment())
        }

        binding.cardView3.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTreningsFragment())
        }
    }

}