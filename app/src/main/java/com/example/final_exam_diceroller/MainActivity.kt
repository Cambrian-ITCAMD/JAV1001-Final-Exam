package com.example.final_exam_diceroller

import android.content.Context
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
    var sides = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPref = getSharedPreferences("save", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val listViewadapter = ArrayAdapter<Int>(this, android.R.layout.simple_list_item_1)


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
            if (!binding.sidesInput.text.isEmpty())
                {
                    sides = (binding.sidesInput.text.toString()).toInt()
                    editor.apply {
                        putInt("dice", sides)
                        apply()
                    }
                    spinneradapter.add(sharedPref.getInt("dice", 0))
                    listViewadapter.add(sharedPref.getInt("dice", 0))
                    binding.historyList.adapter = listViewadapter
                    binding.sidesInput.text.clear()
                }

           else
                Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show()
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