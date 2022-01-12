package com.example.desaafio_12_01

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.desaafio_12_01.databinding.ActivityMainBinding
import kotlinx.coroutines.delay


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)

        binding.btnSave.setOnClickListener(){
            getValue()
        }

        viewModel.textInput.observe(this, Observer {

            binding.tvInput.text=getString(R.string.strTvInput,it.toString())

        })

        binding.btnNewActivity.setOnClickListener() {
            startSecondActivity()
        }

    }

    override fun onRestart() {
        super.onRestart()
        binding.tvWarning.visibility=View.GONE
        binding.etInput.text.clear()
    }


    private fun startSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(SecondActivity.TEXT_KEY, viewModel.textInput.value)
        startActivity(intent)
    }

    private fun getValue(){
        val input=binding.etInput.text.toString()
        if (input.isEmpty())binding.tvWarning.visibility=View.VISIBLE
        else {
            viewModel.setValue(input)
            binding.tvWarning.visibility=View.GONE
        }
    }

}
