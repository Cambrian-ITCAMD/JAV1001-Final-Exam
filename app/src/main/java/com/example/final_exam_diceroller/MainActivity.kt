package com.example.final_exam_diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.final_exam_diceroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    var dice = Dice(4)

    var result2 = 0
    var result3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinneradapter = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item)
        spinneradapter.add(getString(R.string.d4))
        spinneradapter.add(getString(R.string.d6))
        spinneradapter.add(getString(R.string.d8))
        spinneradapter.add(getString(R.string.d10))
        spinneradapter.add(getString(R.string.d12))
        spinneradapter.add(getString(R.string.d20))

        binding.sidesSpinner.adapter = spinneradapter

        binding.sidesSpinner.onItemSelectedListener = this

        binding.roll1.setOnClickListener {
            dice.roll()
            binding.result1.text = dice.getSide_up().toString()
        }
        binding.roll2.setOnClickListener {
            dice.roll()
            binding.result2.text = dice.getSide_up().toString()
            dice.roll()
            binding.result3.text = dice.getSide_up().toString()
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2)
        {
            0 ->
            {
               dice = Dice(4)
            }
            1 ->
            {
                dice = Dice(6)
            }
            2 ->
            {
                dice = Dice(8)
            }
            3 ->
            {
                dice = Dice(10)
            }
            4 ->
            {
                dice = Dice(12)
            }
            5 ->
            {
                dice = Dice(20)
            }

        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }


}