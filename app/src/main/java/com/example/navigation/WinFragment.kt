package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navigation.databinding.FragmentTitleBinding
import com.example.navigation.databinding.FragmentWinBinding


class WinFragment : Fragment() {
    lateinit var binding: FragmentWinBinding

    var earnedscore="0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       binding=DataBindingUtil.inflate(inflater, R.layout.fragment_win, container, false)
        binding.button.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_winFragment_to_titleFragment)
        }
        binding.win=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    arguments?.let {

        val args=WinFragmentArgs.fromBundle(it)
        earnedscore=args.score.toString()
       binding.scoreTextView.setText(earnedscore)

    }

    }
}