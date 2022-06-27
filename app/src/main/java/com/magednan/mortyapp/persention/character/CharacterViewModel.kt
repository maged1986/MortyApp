package com.magednan.mortyapp.persention.character

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.mortyapp.data.mapper.toCharacter
import com.magednan.mortyapp.data.mapper.toCharacterEntity
import com.magednan.mortyapp.data.mapper.toCharacters
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.useCase.AllUseCases
import com.magednan.mortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val allUseCases: AllUseCases) : ViewModel() {


    var state by mutableStateOf(
        CharacterState()
    )

    fun getAllCharacters(fromLocalDb: Boolean) {
        if (fromLocalDb) {
            viewModelScope.launch {
                var localList = ArrayList<Character>()
                allUseCases.getAllFavCharacters.invoke().map {
                    localList.add(it.toCharacter())
                }
                if (localList.isEmpty()) {
                    state = state.copy(isDbEmpty = true, errorMessage = "Empty Db please add Items")

                } else {
                    state = state.copy(data = localList)
                }

            }
        }
        else {
            viewModelScope.launch(Dispatchers.Default) {
                allUseCases.getAllCharacters.invoke().collect { item ->
                    when (item) {
                        is Resource.Loading -> {
                            state = state.copy(isLoading = true)
                        }
                        is Resource.Success -> {
                            Log.d("TAG", "getAllCharacters:${item.data.results.toString()} ")
                            state =
                                state.copy(data = item.data.toCharacters())               //       _characterState.emit(CharacterState(data = state.data.toCharacters()))
                        }
                        is Resource.Error -> {
                            state = state.copy(errorMessage = item.errorMessage)
                        }
                    }

                }
            }
        }
    }

    fun insertAFavCharacter(character: Character) {
        viewModelScope.launch {
            allUseCases.insertAFavCharacter(character.toCharacterEntity())
        }
    }

    fun deleteFavCharacter(character: Character) {
        viewModelScope.launch {
            allUseCases.deleteFavCharacter(character.toCharacterEntity())
        }
    }

}