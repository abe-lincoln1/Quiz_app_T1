package com.example.quizappt1

object Constants{
    fun getquestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val q1= Question(1,"Which country's flag is this?",R.drawable.ic_flag_of_argentina,"Brazil","Argentina","Peru","Columbia",2)
        questionList.add(q1)
        val q2= Question(2,"Which country's flag is this?",R.drawable.ic_flag_of_australia,"Newzealand","UK","Ausralia","Fiji",3)
        questionList.add(q2)
        val q3= Question(3,"Which country's flag is this?",R.drawable.ic_flag_of_india,"Pakistan","Italy","Iran","India",4)
        questionList.add(q3)
        val q4= Question(4,"Which country's flag is this?",R.drawable.ic_flag_of_fiji,"Papua newguinea","Samoa","Fiji","UK",3)
        questionList.add(q4)
        val q5= Question(5,"Which country's flag is this?",R.drawable.ic_flag_of_germany,"Francd","Germany","Russia","Belgium",2)
        questionList.add(q5)
        return questionList
    }
}