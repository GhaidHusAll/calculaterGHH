package com.example.calculator_ghh

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculator_ghh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnAdd.setOnClickListener {
            if (binding.tvUserInput.text != "") {
                binding.tvUserInput.text = "${binding.tvUserInput.text} + "
            }
        }
        binding.btnClear.setOnClickListener {
            binding.tvUserInput.text = ""

        }
        binding.btnDelete.setOnClickListener {
            if (binding.tvUserInput.text != "") {
                binding.tvUserInput.text =
                    binding.tvUserInput.text.substring(0, binding.tvUserInput.text.length - 1)
            }
        }
        binding.btnDiv.setOnClickListener {
            if (binding.tvUserInput.text != "") {
                binding.tvUserInput.text = "${binding.tvUserInput.text} / "
            }
        }
        binding.btnMulti.setOnClickListener {
            if (binding.tvUserInput.text != "") {
                binding.tvUserInput.text = "${binding.tvUserInput.text} * "
            }
        }
        binding.btnSub.setOnClickListener {
            if (binding.tvUserInput.text != "") {
                binding.tvUserInput.text = "${binding.tvUserInput.text} - "
            }
        }
        binding.btnEqual.setOnClickListener {
            //  binding.tvUserInput.text = "${binding.tvUserInput.text}="
            calculation()

        }
        binding.btnPosNegv.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}-"
        }


        binding.btnDot.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}."
        }
        binding.btnNine.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}9"
        }
        binding.btnEight.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}8"
        }
        binding.btnSeven.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}7"
        }
        binding.btnSix.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}6"
        }
        binding.btnFive.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}5"
        }
        binding.btnFour.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}4"
        }
        binding.btnThree.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}3"
        }
        binding.btnTwo.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}2"
        }
        binding.btnOne.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}1"
        }
        binding.btnZero.setOnClickListener {
            binding.tvUserInput.text = "${binding.tvUserInput.text}0"
        }
    }

    private fun calculation(){
        var problem2 = binding.tvUserInput.text.toString().split(" ").toList().toMutableList()
        var result = 0f
        var i = -1

        println("${problem2.size} size")
            while (true) {
                i++
                println("in for ${problem2[i]}")
                when (problem2[i]) {
                    "*" -> {
                        if (checkCorrectForm(problem2[i - 1]) && checkCorrectForm(problem2[i + 1])) {
                            result = problem2[i - 1].toFloat() * problem2[i + 1].toFloat()
                            problem2[i] = result.toString()
                            problem2.removeAt(i + 1)
                            problem2.removeAt(i - 1)
                            println("in when + ${problem2.size}")
                            i = 0
                        }else {
                            Toast.makeText(this, "Problem form is not correct!", Toast.LENGTH_SHORT).show()
                            break
                        }

                    }
                    "/" -> {
                        if (checkCorrectForm(problem2[i - 1]) && checkCorrectForm(problem2[i + 1])) {
                        if (problem2[i - 1].toFloat() == 0F || problem2[i + 1].toFloat() == 0F ){
                            Toast.makeText(this, "can not divide by zero!", Toast.LENGTH_SHORT).show()
                            break
                        }else {
                            result = problem2[i - 1].toFloat() / problem2[i + 1].toFloat()
                            problem2[i] = result.toString()
                            problem2.removeAt(i + 1)
                            problem2.removeAt(i - 1)
                            println("in when + ${problem2.size}")
                            i = 0
                        }
                        }else {
                            Toast.makeText(this, "Problem form is not correct!", Toast.LENGTH_SHORT).show()
                            break
                        }
                    }
                    "+" -> {
                        if (checkCorrectForm(problem2[i - 1]) && checkCorrectForm(problem2[i + 1])) {
                        result = problem2[i - 1].toFloat() + problem2[i + 1].toFloat()
                        problem2[i] = result.toString()
                        problem2.removeAt(i + 1)
                        problem2.removeAt(i - 1)
                        println("in when + ${problem2.size}")
                        i = 0
                    }else {
                    Toast.makeText(this, "Problem form is not correct!", Toast.LENGTH_SHORT).show()
                            break
                }
                    }
                    "-" -> {
                        if (checkCorrectForm(problem2[i - 1]) && checkCorrectForm(problem2[i + 1])) {
                        result = problem2[i - 1].toFloat() - problem2[i + 1].toFloat()
                        problem2[i] = result.toString()
                        problem2.removeAt(i + 1)
                        problem2.removeAt(i - 1)
                        println("in when + ${problem2.size}")
                        i = 0
                        }else {
                            Toast.makeText(this, "Problem form is not correct!", Toast.LENGTH_SHORT).show()
                            break
                        }
                    }

                }
                if (problem2.size == 1){
                    break
                }
            }


        binding.tvUserInput.text = result.toString()
    }

    fun checkCorrectForm(num:String): Boolean {
        return try {
            num.toFloat()
            true
        }catch (e: Exception){
            false
        }
    }
}