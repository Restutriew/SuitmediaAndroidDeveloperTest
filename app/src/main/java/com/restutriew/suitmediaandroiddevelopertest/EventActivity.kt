package com.restutriew.suitmediaandroiddevelopertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.restutriew.suitmediaandroiddevelopertest.databinding.ActivityEventBinding

class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBack.setOnClickListener {
            finish()
        }

        var click = false
        binding.imgMap.setOnClickListener {
            if (!click) {
                binding.imgMap.setImageResource(R.drawable.ic_baseline_format_list_bulleted_24)
                click = true
            } else {
                binding.imgMap.setImageResource(R.drawable.ic_baseline_map_24)
                click = false
            }

        }


    }
}