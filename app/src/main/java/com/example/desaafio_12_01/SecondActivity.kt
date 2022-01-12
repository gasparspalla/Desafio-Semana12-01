package com.example.desaafio_12_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desaafio_12_01.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySecondBinding

    companion object{
        const val TEXT_KEY="text_value"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val textInput=intent.extras!!.getString(TEXT_KEY)
        when{
            textInput!=null->{
                binding.tvSecondAct.text=getString(R.string.strTvSecondAct,textInput)
            }
            else->binding.tvSecondAct.text=getString(R.string.strNotValue)
        }


    }
}