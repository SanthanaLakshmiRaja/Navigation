package com.example.navigation

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentGameBinding
import com.example.navigation.databinding.FragmentWinBinding


class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding

    lateinit var currentquestion :Questions
    var questionindex=0
    lateinit var Answers:ArrayList<String>
    lateinit var SelectedAnswer:String
    var score=0
    var maximumquestion=8



private val question = arrayListOf<Questions>(

    Questions("Which animal is known as the 'Ship of the Desert?", arrayListOf("Camel","Lion","Tiger","Wolf")),
    Questions("How many hours are there in a day?", arrayListOf("24","15","56","12")),
    Questions("Which animal is known as the king of the jungle?", arrayListOf("Lion","Tiger","Camel","Wolf")),
    Questions("Name the National animal of India?", arrayListOf("Tiger","Lion","Camel","Wolf")),
    Questions("Name the place known as the Roof of the World?", arrayListOf("Tibet","Egypt","America","Japan")),
    Questions("Which festival is called the festival of colours?", arrayListOf("Holi","Diwali","Pongal","Onam")),
    Questions("Name the smallest continent?", arrayListOf("Australia","NorthAmerica","Asia","Europe")),
    Questions("Name the country known as the Land of the Rising Sun?", arrayListOf("Japan","Egypt","China","India"))
)


 private fun setquestions() {
     currentquestion = question[questionindex]
     Answers = ArrayList(currentquestion.answers)


     Log.d("ANSWERGROUP",Answers[0]+" "+Answers[1]+" "+Answers[2]+" "+Answers[3])
     Log.d("ANSWERREAL",currentquestion.answers[0])

 }


    private fun checkanswer(answer:String)
    {
    if(answer.equals(currentquestion.answers[0]))
    {
//        binding.ans1textView.setTextColor(Color.WHITE)
//        binding.ans1textView.setBackgroundColor(Color.GREEN)
        score=score+1
        Toast.makeText(activity,"YEAH!!!CORRECT ANSWER",Toast.LENGTH_SHORT).show()

    }
        else{
        Toast.makeText(activity,"SORRY!!!WRONG ANSWER",Toast.LENGTH_SHORT).show()

    }
        questionindex++
//        binding.ans1textView.setTextColor(Color.BLUE)
//        binding.ans1textView.setBackgroundColor(Color.WHITE)
//        binding.ans2textView.setTextColor(Color.BLUE)
//        binding.ans2textView.setBackgroundColor(Color.WHITE)
//        binding.ans3textView.setTextColor(Color.BLUE)
//        binding.ans3textView.setBackgroundColor(Color.WHITE)
//        binding.ans4textView.setTextColor(Color.BLUE)
//        binding.ans4textView.setBackgroundColor(Color.WHITE)
        if(questionindex<maximumquestion)
        {
            setquestions()
          binding.invalidateAll()
        }
        else
        {

            getscores()
        }

    }


    private fun getscores()
    {
        if(score>4) {
            binding.viewscoreButton.setOnClickListener {

              view:View->
//                Navigation.findNavController(view)
//                    .navigate(R.id.action_gameFragment_to_winFragment)
                val action = GameFragmentDirections.actionGameFragmentToWinFragment(score)
              view.findNavController().navigate(action)
            }
        }
        else {
            binding.viewscoreButton.setOnClickListener {
                    view:View->
              //  Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_loseFragment)
                val action = GameFragmentDirections.actionGameFragmentToLoseFragment(score)
                view.findNavController().navigate(action)
            }
        }

    }


    private fun randomquestions()
    {
        question.shuffle()
        setquestions()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false)
//        binding.viewscoreButton.setOnClickListener { view: View ->
//            Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_scoreFragment)
//            val action = GameFragmentDirections.actionGameFragmentToScoreFragment(score)
//            view.findNavController().navigate(action)
//        }
        binding.restartButton.setOnClickListener {
                view: View ->  Navigation.findNavController(view).navigate(R.id.action_gameFragment_to_titleFragment2)
        }
        randomquestions()
        binding.quiz=this

        return  binding.root

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.ans1textView.setOnClickListener{
//            binding.ans1textView.setTextColor(Color.WHITE)
//            binding.ans1textView.setBackgroundColor(Color.GREEN)
            checkanswer( binding.ans1textView.text.toString())


        }

        binding.ans2textView.setOnClickListener{
//            binding.ans2textView.setTextColor(Color.WHITE)
//            binding.ans2textView.setBackgroundColor(Color.RED)
            checkanswer( binding.ans2textView.text.toString())

        }

        binding.ans3textView.setOnClickListener{
//            binding.ans3textView.setTextColor(Color.WHITE)
//            binding.ans3textView.setBackgroundColor(Color.RED)
            checkanswer( binding.ans3textView.text.toString())

        }

        binding.ans4textView.setOnClickListener{
//            binding.ans4textView.setTextColor(Color.WHITE)
//            binding.ans4textView.setBackgroundColor(Color.RED)
            checkanswer( binding.ans4textView.text.toString())

        }

    }
    }
