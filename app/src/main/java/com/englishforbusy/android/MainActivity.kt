package com.englishforbusy.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.englishforbusy.android.data.model.Word

class MainActivity : AppCompatActivity() {

    val list = mutableListOf<Word>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list.add(Word("room", "кімната"))
    }
}