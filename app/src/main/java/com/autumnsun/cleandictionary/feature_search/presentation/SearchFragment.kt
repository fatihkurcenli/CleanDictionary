package com.autumnsun.cleandictionary.feature_search.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.autumnsun.cleandictionary.R
import com.autumnsun.cleandictionary.core.presentation.BaseFragment
import com.autumnsun.cleandictionary.databinding.FragmentSearchBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    private val searchViewModel by viewModels<SearchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createTabLayout()

        binding.autoCompleteTextView.doAfterTextChanged {
            searchViewModel.onSearch(it.toString())
        }

        lifecycleScope.launch {
            searchViewModel.state.collectLatest { wordInfoState ->
                Log.d("Tag", wordInfoState.wordInfoItems.toString())
            }
        }

        lifecycleScope.launchWhenCreated {
            searchViewModel.eventFlow.collectLatest { searchEvent ->
                when (searchEvent) {
                    is SearchUIEvent.ShowSnackBar -> {
                        val snackError = Snackbar.make(
                            binding.root,
                            searchEvent.message,
                            Snackbar.LENGTH_SHORT
                        )
                        snackError.animationMode = Snackbar.ANIMATION_MODE_FADE
                        snackError.show()
                    }
                }
            }
        }
    }

    private fun createTabLayout() {
        binding.tabLayout.newTab().text = "Tümü"
        binding.tabLayout.newTab().text = "Kelime"
        binding.tabLayout.newTab().text = "Atasözü"
    }

    override fun getViewBinding() = FragmentSearchBinding.inflate(layoutInflater)
}