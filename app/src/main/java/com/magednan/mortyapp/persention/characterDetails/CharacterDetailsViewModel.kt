package com.magednan.mortyapp.persention.characterDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.useCase.AllUseCases
import com.magednan.mortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val allUseCases: AllUseCases
):ViewModel() {

    var state by mutableStateOf(CharacterDetailsState())

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }
    fun getEpisodes (list: List<String>) {
         viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
             allUseCases.getEpisodes.invoke(list).collect{resource->
                 when(resource){
                     is Resource.Success->{state=state.copy(data = resource.data)
                     }
                 }
             Log.d("TAG", "getEpisodes:${resource.toString()} ")}
         }
    }}

