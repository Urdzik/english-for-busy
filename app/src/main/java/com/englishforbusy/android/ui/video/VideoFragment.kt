package com.englishforbusy.android.ui.video

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
import com.englishforbusy.android.databinding.FragmentVideoBinding
import com.englishforbusy.android.ui.auth.login.LoginViewModel

class VideoFragment : Fragment() {

    companion object {
        fun newInstance() = VideoFragment()
    }

    private val binding: FragmentVideoBinding by viewBinding()
    private val viewModel: VideoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_video, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lifecycle.addObserver(binding.youtubePlayerView);

        val click = View.OnClickListener { findNavController().navigate(VideoFragmentDirections.actionVideoFragmentToQuestionFragment()) }
        binding.textSkip.setOnClickListener(click)
        binding.button2.setOnClickListener(click)
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }
        }

    }

