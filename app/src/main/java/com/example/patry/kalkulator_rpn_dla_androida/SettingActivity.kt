package com.example.patry.kalkulator_rpn_dla_androida

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*
import kotlin.collections.ArrayList



class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        redSeekBar.progress = 255
        greenSeekBar.progress = 255
        blueSeekBar.progress = 255

        val precision : Int = intent.getIntExtra("precision", 2)
        val red : Int = intent.getIntExtra("red", 255)
        val green : Int = intent.getIntExtra("green", 255)
        val blue : Int = intent.getIntExtra("blue", 255)

        //precisionEditText.setText(precision)
        redTextView.text = red.toString()
        greenTextView.text = green.toString()
        blueTextView.text = blue.toString()
        redSeekBar.progress = red
        greenSeekBar.progress = green
        blueSeekBar.progress = blue

        backButton.setOnClickListener {
            val edit : String = intent.getStringExtra("editTextView")
            val first : String = intent.getStringExtra("firstStackLevel")
            val second : String = intent.getStringExtra("secondStackLevel")
            val third : String = intent.getStringExtra("thirdStackLevel")
            val fourth : String = intent.getStringExtra("fourthStackLevel")
            //val stack : LinkedList<String> = intent.extras.get("stack") as LinkedList<String>

            val backIntent = Intent(this, MainActivity::class.java)
            backIntent.putExtra("editTextView", edit)
            backIntent.putExtra("firstStackLevel", first)
            backIntent.putExtra("secondStackLevel", second)
            backIntent.putExtra("thirdStackLevel", third)
            backIntent.putExtra("fourthStackLevel", fourth)
            //backIntent.putExtra("stack", stack as Serializable)
            backIntent.putExtra("precision", precisionEditText.text.toString().toInt())
            backIntent.putExtra("red", redTextView.text.toString().toInt())
            backIntent.putExtra("green", greenTextView.text.toString().toInt())
            backIntent.putExtra("blue", blueTextView.text.toString().toInt())
            setResult(Activity.RESULT_OK, backIntent)
            finish()
        }

        redSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                // TODO Auto-generated method stub
                redTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }
        })

        greenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                // TODO Auto-generated method stub
                greenTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }
        })

        blueSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                // TODO Auto-generated method stub
                blueTextView.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }
        })
    }
}
