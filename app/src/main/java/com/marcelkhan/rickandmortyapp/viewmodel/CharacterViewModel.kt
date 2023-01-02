package com.marcelkhan.rickandmortyapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcelkhan.rickandmortyapp.repository.CharacterRepository
import com.marcelkhan.rickandmortyapp.model.characters.Character
import com.marcelkhan.rickandmortyapp.model.characters.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val characterRepository: CharacterRepository
): ViewModel() {

    private val _characters = MutableStateFlow(Character(Info(0, "", 0, null), emptyList()))
    val characters = _characters.asStateFlow()

    init {
        viewModelScope.launch {
            _characters.value = characterRepository.getCharacters()
        }
    }
}