package com.autumnsun.cleandictionary.feature_search.presentation

sealed class SearchUIEvent {
    data class ShowSnackBar(val message: String) : SearchUIEvent()
}