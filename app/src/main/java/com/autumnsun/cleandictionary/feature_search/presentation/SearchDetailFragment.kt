package com.autumnsun.cleandictionary.feature_search.presentation

import android.os.Bundle
import android.view.View
import com.autumnsun.cleandictionary.R
import com.autumnsun.cleandictionary.core.presentation.BaseFragment
import com.autumnsun.cleandictionary.databinding.FragmentSearchBinding


class SearchDetailFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search_detail) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
}