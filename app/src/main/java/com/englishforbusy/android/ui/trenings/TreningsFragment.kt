package com.englishforbusy.android.ui.trenings

import android.app.SearchManager
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.R
import com.englishforbusy.android.databinding.FragmentLoginBinding
import com.englishforbusy.android.databinding.FragmentTreningsBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel
import com.englishforbusy.android.ui.home.HomeFragmentDirections
import java.util.*
import kotlin.random.Random

class TreningsFragment : Fragment() {

    companion object {
        fun newInstance() = TreningsFragment()
    }

    private val binding: FragmentTreningsBinding by viewBinding()
    private val viewModel: TreningsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_trenings, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }


        val navigate: NavDirections

        val intRandom = Random.nextInt(0, 100)
        navigate = when {
            intRandom <= 35 -> TreningsFragmentDirections.actionTreningsFragmentToVideoFragment()
            intRandom in 36..65 -> TreningsFragmentDirections.actionTreningsFragmentToSentensFragment()
            else -> TreningsFragmentDirections.actionTreningsFragmentToCardFragment()
        }

        val cklick = View.OnClickListener { findNavController().navigate(navigate) }
        binding.cardView3.setOnClickListener(cklick)
        binding.cardView4.setOnClickListener(cklick)
        binding.cardView5.setOnClickListener(cklick)


    }

}