package com.autumnsun.cleandictionary.feature_home.presentation

import android.os.Bundle
import android.view.View
import com.autumnsun.cleandictionary.R
import com.autumnsun.cleandictionary.core.presentation.BaseFragment
import com.autumnsun.cleandictionary.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)
}