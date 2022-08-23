package com.restutriew.suitmediaandroiddevelopertest

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.restutriew.suitmediaandroiddevelopertest.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    var filePath: Uri? = null

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfil.setOnClickListener {
            ImagePicker.with(this)
                .start()
        }

        binding.btnNext.setOnClickListener {
            val textName = binding.etName.text.toString()
            val textPalindrome = binding.etPalindrome.text.toString()
            if (textName.isNullOrEmpty()) {
                binding.etName.error = "Please insert your name"
                binding.etName.requestFocus()
            } else if (textPalindrome.isNullOrEmpty()) {
                binding.etPalindrome.error = "Please insert palindrome text"
                binding.etPalindrome.requestFocus()
            } else {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
            }
        }

        binding.btnCheck.setOnClickListener {
            val textPalindrome = binding.etPalindrome.text.toString()
            if (checkPalindrome(textPalindrome)) {
                Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Entered word is not palindrome ", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun checkPalindrome(text: String): Boolean {
        val reverseString = text.reversed().toString()
        return text.equals(reverseString, ignoreCase = true)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (resultCode == Activity.RESULT_OK) {
//            filePath = data?.data
//
//            Glide.with(this)
//                .load(filePath)
//                .apply(RequestOptions.circleCropTransform())
//                .into(ivProfil)
//        } else if (resultCode == ImagePicker.RESULT_ERROR) {
//            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Task Cancelled", Toast.LENGTH_SHORT).show()
//        }
//    }
}
