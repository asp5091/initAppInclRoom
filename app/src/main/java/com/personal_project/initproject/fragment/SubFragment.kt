package com.personal_project.initproject.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.personal_project.initproject.databinding.FragmentSubBinding

lateinit var binding : FragmentSubBinding

class SubFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSubBinding.inflate(layoutInflater)
        return binding.root
    }
}