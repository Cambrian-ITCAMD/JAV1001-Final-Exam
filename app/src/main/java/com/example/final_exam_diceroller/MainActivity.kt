package com.example.final_exam_diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.final_exam_diceroller.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMainBinding
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
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when(p2)
        {
            0 ->
            {

            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        //TODO("Not yet implemented")
    }

}