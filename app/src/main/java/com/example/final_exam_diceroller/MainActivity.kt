package com.example.final_exam_diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import com.example.final_exam_diceroller.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    var dice = Dice(4)
    var value = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinneradapter = ArrayAdapter<Int>(this, android.R.layout.simple_spinner_item)
        spinneradapter.add(4)
        spinneradapter.add(6)
        spinneradapter.add(8)
        spinneradapter.add(10)
        spinneradapter.add(12)
        spinneradapter.add(20)

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


        binding.add.setOnClickListener {
            if (binding.sidesInput.text != null) {
                spinneradapter.add((binding.sidesInput.text.toString()).toInt())
                binding.sidesInput.text.clear()
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

      var position = binding.sidesSpinner.getPositionForView(p1)
        value = binding.sidesSpinner.getItemAtPosition(position).toString().toInt()
                   dice = Dice(value)
    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }


}