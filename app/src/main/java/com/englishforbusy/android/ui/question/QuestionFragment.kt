package com.englishforbusy.android.ui.question

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.R
import com.englishforbusy.android.data.model.GrammarTest
import com.englishforbusy.android.databinding.FragmentQuestionBinding

class QuestionFragment : Fragment() {
    private val questionsList: MutableList<GrammarTest> = mutableListOf()
    private var currentTest: Int = 0

    companion object {
        fun newInstance() = QuestionFragment()
    }

    private val binding: FragmentQuestionBinding by viewBinding()
    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun setList(){
        questionsList.addAll(listOf(
            GrammarTest("What article should be used when talking about unfamiliar object?", )
        ))
    }
}