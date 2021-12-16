package com.autumnsun.cleandictionary.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.autumnsun.cleandictionary.databinding.ActivityMainBinding
import com.autumnsun.cleandictionary.feature_dictionary.presentation.WordInfoViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: WordInfoViewModel by viewModels()
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.searchQuery.doAfterTextChanged {
            viewModel.onSearch(it.toString())
        }


        lifecycleScope.launchWhenCreated {

            viewModel.state.collectLatest {
                if (it.isLoading) {
                    Log.d("TAG", "Loading")
                } else {
                    Log.d("TAG", "Loading stop")
                }
                if (it.wordInfoItems.isNotEmpty()) {
                    Log.d("TAG", it.wordInfoItems.toString())
                }
            }

            viewModel.eventFlow.collectLatest { event ->
                when (event) {
                    is WordInfoViewModel.UIEvent.ShowSnackBar -> {
                        Snackbar
                            .make(binding.root, event.message, Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}