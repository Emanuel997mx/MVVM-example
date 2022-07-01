package com.emanuel.mvvmexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.emanuel.mvvmexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    private val characterViewModel: CharacterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        characterViewModel.onCreate()
        listenToChanges()
    }

    private fun listenToChanges() {
        characterViewModel.characterModel.observe(this, Observer{
            Glide.with(applicationContext)
                .load(it.image)
                .centerCrop()
                .into(binding.ivCharacter)
            binding.tvNameCharacter.text = it.name
            binding.tvGenderCharacter.text = it.gender
            binding.tvSpecieCharacter.text = it.species
            binding.tvStateCharacter.text = it.status
        })
    }


}