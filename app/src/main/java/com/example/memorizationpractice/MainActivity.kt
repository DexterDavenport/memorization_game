package com.example.memorizationpractice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rand = (1000000..9999999).random()
        val user_guess = findViewById<EditText>(R.id.user_guess)
        user_guess.setVisibility(View.GONE)
        val check_button = findViewById<Button>(R.id.check_button)
        val restart_button = findViewById<Button>(R.id.restart_button)
        val disappearing_number = findViewById<TextView>(R.id.disappearing_number)

//        disappearing_number.setVisibility(View.GONE)
        disappearing_number.postDelayed(Runnable { disappearing_number.setVisibility(View.GONE) }, 10000)
        user_guess.postDelayed(Runnable { user_guess.setVisibility(View.VISIBLE) }, 20000)
        disappearing_number.text = "$rand"
        check_button.setOnClickListener { check_user_answer(rand) }

        restart_button.setOnClickListener { restart() }
    }

    private fun restart() {
        setContentView(R.layout.activity_main)
        val rand = (1000000..9999999).random()
        val user_guess = findViewById<EditText>(R.id.user_guess)
        user_guess.setVisibility(View.GONE)
        val check_button = findViewById<Button>(R.id.check_button)
        val restart_button = findViewById<Button>(R.id.restart_button)
        val disappearing_number = findViewById<TextView>(R.id.disappearing_number)

//        disappearing_number.setVisibility(View.GONE)
        disappearing_number.postDelayed(Runnable { disappearing_number.setVisibility(View.GONE) }, 10000)
        user_guess.postDelayed(Runnable { user_guess.setVisibility(View.VISIBLE) }, 20000)
        disappearing_number.text = "$rand"
        check_button.setOnClickListener { check_user_answer(rand) }
        restart_button.setOnClickListener { restart() }
    }

    private fun check_user_answer(rand: Int) {
        try {

            val user_guess = findViewById<EditText>(R.id.user_guess)
            val user_input = user_guess.text.toString().toInt()
            val rand_num = (rand)
            if (rand_num == user_input) {
                val answer_solution = findViewById<TextView>(R.id.check_answer)
                answer_solution.text = "Correct"
//                val rand1 = (0..10).random()
//                val rand2 = (0..10).random()
//                val question = findViewById<TextView>(R.id.question)
//                question.text = "$rand1 + $rand2"
            } else {
                val answer_solution = findViewById<TextView>(R.id.check_answer)
                answer_solution.text = "Wrong"
                val answer_solution2 = findViewById<TextView>(R.id.answer_solution2)
                answer_solution2.setVisibility(View.GONE)
                answer_solution2.postDelayed(Runnable { answer_solution2.setVisibility(View.VISIBLE) }, 5000)
                answer_solution2.text = "$rand"
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_LONG).show()
        }
    }
}