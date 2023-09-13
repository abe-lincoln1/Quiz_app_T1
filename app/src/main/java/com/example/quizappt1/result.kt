package com.example.quizappt1

import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val intValue= intent.getIntExtra("intVariableName",0)
        res()

    }
    private fun res(){
        val intValue= intent.getIntExtra("intVariableName",0)
        val im: ImageView =findViewById(R.id.image)
        val text: TextView =findViewById(R.id.textt)
        val tv:TextView=findViewById(R.id.score)
        val rat: RatingBar =findViewById(R.id.ratebar)
        when(intValue){
            5->{
                im.setImageResource(R.drawable.runner)
                text.text="Well done"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
            4->{
                im.setImageResource(R.drawable.runner)
                text.text="Well done"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
            3->{
                im.setImageResource(R.drawable.drawing)
                text.text="Need to improve"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
            2->{
                im.setImageResource(R.drawable.drawing)
                text.text="Need to improve"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
            1->{
                im.setImageResource(R.drawable.heartbroken)
                text.text="Better luck next time"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
            0->{
                im.setImageResource(R.drawable.heartbroken)
                text.text="Better luck next time"
                tv.text="${intValue.toString()}"+"/"+"5"
                rat.rating=intValue.toFloat()
            }
        }
    }

}