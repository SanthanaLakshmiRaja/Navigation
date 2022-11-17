package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.navigation.databinding.FragmentLoseBinding
import com.example.navigation.databinding.FragmentTitleBinding

class LoseFragment : Fragment() {

    var earnedscore="0"
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoseBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_lose, container, false)
        binding.button.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_loseFragment_to_titleFragment)
        }
        binding.scoreearned=this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {

            val args=LoseFragmentArgs.fromBundle(it)
            earnedscore=args.score.toString()

        }
    }
}