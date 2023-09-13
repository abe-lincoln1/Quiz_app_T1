package com.example.quizappt1

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class quizquestions : AppCompatActivity(),View.OnClickListener{
    var mcurrentposition:Int=1
    var mselectedop:Int=0
    var score:Int=0
    var questionlist:ArrayList<Question>?=Constants.getquestions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizquestions)

        val opt1:TextView=findViewById(R.id.tv_Op1)
        val opt2:TextView=findViewById(R.id.tv_Op2)
        val opt3:TextView=findViewById(R.id.tv_Op3)
        val opt4:TextView=findViewById(R.id.tv_Op4)
        val btn:Button=findViewById(R.id.sub_btn)
        setquestion()
        opt1.setOnClickListener(this)
        opt2.setOnClickListener(this)
        opt3.setOnClickListener(this)
        opt4.setOnClickListener(this)
        btn.setOnClickListener(this)

        }


    private fun setquestion() {
        val qst: Question? = questionlist?.get(mcurrentposition - 1)
        val pb: ProgressBar =findViewById(R.id.progressbar)
        pb.progress=mcurrentposition
        val tvpb: TextView =findViewById(R.id.tvpb)
        tvpb.text="$mcurrentposition"+"/"+"5"
        val tvq:TextView=findViewById(R.id.tv_que)
        tvq.text=qst!!.qs
        val ivim: ImageView =findViewById(R.id.iv)
        val opt1:TextView=findViewById(R.id.tv_Op1)
        val opt2:TextView=findViewById(R.id.tv_Op2)
        val opt3:TextView=findViewById(R.id.tv_Op3)
        val opt4:TextView=findViewById(R.id.tv_Op4)
        ivim.setImageResource(qst.image)
        opt1.text=qst!!.op1
        opt2.text=qst!!.op2
        opt3.text=qst!!.op3
        opt4.text=qst!!.op4
        defaultOptionView()
        val btn:Button=findViewById(R.id.sub_btn)
        btn.text="SUBMIT"

    }

    private fun defaultOptionView(){
        val opt1:TextView=findViewById(R.id.tv_Op1)
        val opt2:TextView=findViewById(R.id.tv_Op2)
        val opt3:TextView=findViewById(R.id.tv_Op3)
        val opt4:TextView=findViewById(R.id.tv_Op4)
        val options=ArrayList<TextView>()
        options.add(0, opt1)
        options.add(1, opt2)
        options.add(2, opt3)
        options.add(3, opt4)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this, R.drawable.default_option)
        }
    }
    private fun selectedop(tv: TextView, selectedopnum: Int){
        defaultOptionView()
        mselectedop=selectedopnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this, R.drawable.selected_option)

    }
    private fun answer_view(ans: Int, drawableview: Int){
        var opt1:TextView=findViewById(R.id.tv_Op1)
        var opt2:TextView=findViewById(R.id.tv_Op2)
        var opt3:TextView=findViewById(R.id.tv_Op3)
        var opt4:TextView=findViewById(R.id.tv_Op4)
        when(ans){
            1 -> {
                opt1.background = ContextCompat.getDrawable(this, drawableview)
            }
            2 -> {
                opt2.background = ContextCompat.getDrawable(this, drawableview)
            }
            3 -> {
                opt3.background = ContextCompat.getDrawable(this, drawableview)
            }
            4 -> {
                opt4.background = ContextCompat.getDrawable(this, drawableview)
            }
        }
    }
    override fun onClick(v: View?) {
        val opt1:TextView=findViewById(R.id.tv_Op1)
        val opt2:TextView=findViewById(R.id.tv_Op2)
        val opt3:TextView=findViewById(R.id.tv_Op3)
        val opt4:TextView=findViewById(R.id.tv_Op4)
        val btn:Button=findViewById(R.id.sub_btn)
        when(v?.id){
            R.id.tv_Op1 -> {
                selectedop(opt1, 1)
            }
            R.id.tv_Op2 -> {
                selectedop(opt2, 2)
            }
            R.id.tv_Op3 -> {
                selectedop(opt3, 3)
            }
            R.id.tv_Op4 -> {
                selectedop(opt4, 4)
            }
            R.id.sub_btn -> {
                if (mselectedop == 0) {
                    mcurrentposition++
                    when {
                        mcurrentposition <= questionlist!!.size -> {
                            setquestion()
                        }
                        else -> {
                            val myIntent = Intent(this,result::class.java)
                            myIntent.putExtra("intVariableName", score)
                            startActivity(myIntent)
                            finish()
                        }

                    }

                } else {
                    val qst = questionlist?.get(mcurrentposition - 1)
                    if (qst!!.correctop != mselectedop) {
                        answer_view(mselectedop, R.drawable.wrong_op_view)

                    } else {
                        score++
                    }
                    answer_view(qst.correctop, R.drawable.correct_op_view)

                    if (mcurrentposition == questionlist!!.size) {
                        val myIntent = Intent(this,result::class.java)
                        myIntent.putExtra("intVariableName", score)
                        startActivity(myIntent)
                        finish()

                    } else {
                        btn.text = "Go to next question"
                    }
                    mselectedop = 0

                }

            }
        }




    }







}