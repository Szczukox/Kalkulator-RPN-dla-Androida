package com.example.patry.kalkulator_rpn_dla_androida

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_setting.*
import java.util.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)


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
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
