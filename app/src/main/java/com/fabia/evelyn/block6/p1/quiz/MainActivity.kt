package com.fabia.evelyn.block6.p1.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tv_time: TextView
    lateinit var tv_clicks: TextView

    lateinit var b_start: Button
    lateinit var b_click: Button

    var currentTime = 10
    var currentClicks = 0

    lateinit var timer: CountDownTimer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_time = findViewById(R.id.tv_time)
        tv_clicks = findViewById(R.id.tv_clicks)

        b_start = findViewById(R.id.b_start)
        b_click = findViewById(R.id.b_click)

        b_click.isEnabled = false

        b_start.setOnClickListener {

            currentTime = 10
            currentClicks = 0

            tv_time.text = "Time: $currentTime"
            tv_clicks.text = "Clicks: $currentClicks"

            //ayaw mag-click//

            b_start.isEnabled = false
            b_click.isEnabled = true

            timer.start()
        }

        b_click.setOnClickListener {
            currentClicks++;
            tv_clicks.text = "Clicks: $currentClicks"
        }

        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentTime--
                val time = currentTime + 1
                tv_time.text = "Time: $time"
            }

            override fun onFinish() {
                tv_time.text = "Time: 0"

                b_start.isEnabled = true
                b_click.isEnabled = false

                //ayaw nagana//
            }

        }
    }
}