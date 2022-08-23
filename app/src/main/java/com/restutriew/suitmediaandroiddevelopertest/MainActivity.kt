package com.restutriew.suitmediaandroiddevelopertest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.restutriew.suitmediaandroiddevelopertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnChooseEvent.setOnClickListener {
            startActivity(Intent(this@MainActivity, EventActivity::class.java))
        }

        binding.btnChooseGuest.setOnClickListener {
            startActivity(Intent(this@MainActivity, GuestActivity::class.java))
        }


    }
}