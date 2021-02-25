package com.englishforbusy.android.ui.card

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.englishforbusy.android.R
import com.englishforbusy.android.data.model.Word
import com.englishforbusy.android.databinding.FragmentCardBinding
import java.util.*


class CardFragment : Fragment() {
    var t1: TextToSpeech? = null
    private val list = listOf(
        Word("ambiguous", "Сумнівний"),
        Word("conventional", "Звичайний"),
        Word("disguise", "одяг для маскування, переодягання"),
        Word("hilarious", "веселий"),
        Word("catchy", "легкий для запамятовування"),
        Word("friction", "протирічча"),
        Word("gripping", "Захоплюючий"),
        Word("sombre", "Темний, похмурий"),
        Word("dated", "Застарілий"),
        Word("bully", "Хуліган"),
    )
    var index = 0

    var ifClick = false

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
        var t1 = TextToSpeech(
            activity?.applicationContext
        ) {
            if(it != TextToSpeech.ERROR) {
                t1?.language = Locale.US;
            }
        }

        binding.imageView8.setOnClickListener {
            val toSpeak: String = list[index].en
            t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null)
        }
        binding.imageView7.setOnClickListener {
            findNavController().popBackStack()
        }

        setData(list[0])

        binding.to.setOnClickListener {
            if (index != 9) {
                index++
                setData(list[index])
                binding.progress.setProgress(((index + 1) * 10), true)
                if (index != 0) {
                        binding.back.visibility = View.VISIBLE
                }
            }
        }

        binding.back.setOnClickListener {
            index--
            setData(list[index])
            binding.progress.setProgress(((index - 1) * 10), true)
            if (index == 0) {
                binding.back.visibility = View.GONE
            }
        }

    }

    override fun onPause() {
        if (t1 != null) {
            t1!!.stop()
            t1!!.shutdown()
        }
        super.onPause()
    }

    private fun setData(data: Word) {
        binding.word.text = data.en

        binding.cardView6.setOnClickListener {
            if (ifClick) {
                binding.word.text = data.en
            } else {
                binding.word.text = data.ua
            }
            ifClick = !ifClick
        }
        binding.count.text = "${index.toInt() + 1}/10"

    }

}