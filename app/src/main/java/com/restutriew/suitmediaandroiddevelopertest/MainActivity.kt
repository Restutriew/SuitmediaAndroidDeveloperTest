package com.restutriew.suitmediaandroiddevelopertest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.restutriew.suitmediaandroiddevelopertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var session: SessionManager
    private var name = ""
    private var guest = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        session = SessionManager(applicationContext)

        val user: HashMap<String, String> = session.getUserDetails()
        name = user.get(SessionManager.KEY_NAME)!!
        guest = user.get(SessionManager.KEY_GUEST)!!

        binding.btnChooseEvent.setOnClickListener {
            startActivity(Intent(this@MainActivity, EventActivity::class.java))
        }

        binding.btnChooseGuest.setOnClickListener {
            startActivity(Intent(this@MainActivity, GuestActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()

        binding.tvName.text = name
        if (guest == "null") {
        } else {
            binding.btnChooseGuest.text = guest

        }
    }
}