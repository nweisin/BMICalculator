package com.example.myapplication

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var size_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cal_Button: Button = findViewById(R.id.calButton)
        cal_Button.setOnClickListener{
            var heights:Double = Heights.text.toString().toDouble()
            var weights:Double = Weights.text.toString().toDouble()
            cal(heights,weights)
        }

        val reset: Button = findViewById(R.id.Reset)
        reset.setOnClickListener{
            Heights.text = null
            Weights.text = null
            bminum.text = null
            size.setImageResource(R.drawable.empty)
        }

        size_image = findViewById(R.id.size)
    }

    private fun cal(heights:Double, weights:Double){
        val say:String = "The BMI is"
        val BMI:Double = weights / (heights*heights)
        val BMI2Dec:Double = String.format("%.2f",BMI).toDouble()
        val BMInum:Int
        if (BMI < 18.5){
            BMInum = 1
        }else if (BMI > 25){
            BMInum = 2
        }else{
            BMInum = 0
        }
        val DrawableResource = when (BMInum){
            1 ->R.drawable.under
            2 ->R.drawable.over
            else ->R.drawable.normal
        }
        bminum.text =say + BMI2Dec.toString()
        size.setImageResource(DrawableResource)

    }
}