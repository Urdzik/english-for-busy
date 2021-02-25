package com.englishforbusy.android.ui.question

import android.app.AlertDialog
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
        setList()
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }
        resetTest()
        binding.to.setOnClickListener {
            if(currentTest == 0) {
                currentTest++
                resetTest()
                binding.back.visibility = View.VISIBLE
            }
            else if (currentTest <= questionsList.size - 2) {
                currentTest++
                resetTest()
                binding.back.visibility = View.VISIBLE
            } else {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Success!")
                builder.setMessage("Congratulations! You have passed the daily test!")
                builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                    findNavController().popBackStack(R.id.homeFragment, false)
                }
                builder.show()
            }
        }
        binding.back.setOnClickListener {
            if (currentTest > 0) {
                currentTest--
                resetBackTest()
            }
        }
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }

    private fun resetTest() {
        var currentTest = questionsList[currentTest]
        binding.textView8.text = currentTest.question
        binding.textView16.text = currentTest.fAnswer
        binding.textView17.text = currentTest.sAnswer
        binding.textView18.text = currentTest.lAnswer
        binding.checkBox.isChecked = false
        binding.checkBox2.isChecked = false
        binding.checkBox3.isChecked = false
        binding.oneFrom.text = "${this.currentTest+1}/10"
        binding.progress.progress = this.currentTest
        if(this.currentTest == 0) binding.back.visibility = View.GONE
    }

    private fun resetBackTest() {
        var currentTest = questionsList[currentTest]
        binding.textView8.text = currentTest.question
        binding.textView16.text = currentTest.fAnswer
        binding.textView17.text = currentTest.sAnswer
        binding.textView18.text = currentTest.lAnswer
        binding.checkBox.isChecked = true
        binding.checkBox2.isChecked = false
        binding.checkBox3.isChecked = false
        binding.oneFrom.text = "${this.currentTest+1}/10"
        binding.progress.progress = this.currentTest + 1
        if(this.currentTest == 0) binding.back.visibility = View.GONE
    }

    private fun setList() {
        questionsList.addAll(
            listOf(
                GrammarTest(
                    "What article should be used before an unfamiliar object?",
                    "article a/an",
                    "article the",
                    "both of articles"
                ),
                GrammarTest(
                    "Choose the correct construction:",
                    "I wish I could be happy",
                    "I'm wish to be happy",
                    "I wish that I could being happy"
                ),
                GrammarTest(
                    "Find the sentence with a mistake",
                    "I dream of travelling a lot",
                    "It is a suspicious thing",
                    "I am tasting a dish now"
                ),
                GrammarTest(
                    "What tense form is correct?",
                    "I have been doing these notes for two days",
                    "I am create a new book",
                    "Might I bought that suit?"
                ),
                GrammarTest(
                    "Choose the correct use of an article the:",
                    "I climb the mountains ",
                    "Girl have seen the river",
                    "It was the better choice"
                ),
                GrammarTest(
                    "Find the sentence with a mistake:",
                    "He was seen the beautiful sunset",
                    "Can you borrow me some money?",
                    "Please, don't be afraid"
                ),
                GrammarTest(
                    "What tense form is correct?",
                    "I had done the task now",
                    "Can you have borrowed me an pen?",
                    "I am try to understand it"
                ),
                GrammarTest(
                    "Choose the correct construction:",
                    "How dare you?",
                    "How are you dare?",
                    "How can dare you?"
                ),
                GrammarTest(
                    "Find the sentence with a mistake?",
                    "What is the reference?",
                    "Should not we do that?",
                    "Can I sing some song for you?"
                ),
                GrammarTest(
                    "What article should be used when talking about familiar object?",
                    "article a/n",
                    "article the",
                    "both of articles"
                ),
            )
        )
    }
}