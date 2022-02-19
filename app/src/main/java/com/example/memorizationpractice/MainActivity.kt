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
//        call the restart function for the first time when the app is started
        restart()
    }

//    This function basically runs the whole program again every time the restart button is presses
    private fun restart() {
        setContentView(R.layout.activity_main)
//    generate the random seven digits
        val rand = (1000000..9999999).random()
//    set the user guess to the EditText created in the activity_main.xml
        val user_guess = findViewById<EditText>(R.id.user_guess)
//    set the remember me text to the TextView created in the activity_main.xml
        val rememberMe = findViewById<TextView>(R.id.rememberMe)
//    stops the user_guess from being seen
        user_guess.setVisibility(View.GONE)
//    set the check answer button to the Button created in the activity_main.xml
        val check_button = findViewById<Button>(R.id.check_button)
//    stop the check_button from being seen
        check_button.setVisibility(View.GONE)
//    set the dontForget text to the TextView created in the activity_main.xml
        val dontForget = findViewById<TextView>(R.id.dontForget)
//    make the dontForget text invisable
        dontForget.setVisibility(View.GONE)
//    set the restart button to the Button created in the activity_main.xml
        val restart_button = findViewById<Button>(R.id.restart_button)
//    set the disabppearing number text to the TextView created in the activity_main.xml
        val disappearing_number = findViewById<TextView>(R.id.disappearing_number)
//    These next couple of lines set the visibilty of all fo the buttons and text to appear/disappear at determined times
        disappearing_number.postDelayed(Runnable { disappearing_number.setVisibility(View.GONE) }, 10000)
        rememberMe.postDelayed(Runnable { rememberMe.setVisibility(View.GONE) }, 10000)
        dontForget.postDelayed(Runnable { dontForget.setVisibility(View.VISIBLE) }, 10000)
        dontForget.postDelayed(Runnable { dontForget.setVisibility(View.GONE) }, 20000)
        user_guess.postDelayed(Runnable { user_guess.setVisibility(View.VISIBLE) }, 20000)
        check_button.postDelayed(Runnable { check_button.setVisibility(View.VISIBLE) }, 20000)
        disappearing_number.text = "$rand"
//    calls the check_user_answer function the check_button is pressed
        check_button.setOnClickListener { check_user_answer(rand) }
//    restarts the program when teh restart_button is pressed
        restart_button.setOnClickListener { restart() }
    }


//    check if the users answer matches the random generated number
    private fun check_user_answer(rand: Int) {
        try {

            val user_guess = findViewById<EditText>(R.id.user_guess)
            val user_input = user_guess.text.toString().toInt()
            val rand_num = (rand)
//            check if the user is correct
            if (rand_num == user_input) {
                val answer_solution = findViewById<TextView>(R.id.check_answer)
                answer_solution.text = "Correct"
                val answer_solution2 = findViewById<TextView>(R.id.answer_solution2)
                answer_solution2.setVisibility(View.GONE)
//            if the user is wrong it will run this
            } else {
                val answer_solution = findViewById<TextView>(R.id.check_answer)
                answer_solution.text = "Wrong"
                val answer_solution2 = findViewById<TextView>(R.id.answer_solution2)
                answer_solution2.setVisibility(View.GONE)
//                redisplay the random number five seconds after getting the number wrong
                answer_solution2.postDelayed(Runnable { answer_solution2.setVisibility(View.VISIBLE) }, 5000)
                answer_solution2.text = "$rand"
            }
        } catch (e: Exception) {
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_LONG).show()
        }
    }
}