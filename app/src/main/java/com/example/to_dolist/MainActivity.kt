package com.example.to_dolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.to_dolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var  binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}