package com.magednan.mortyapp.persention.episodeDetails

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.mortyapp.domain.useCase.AllUseCases
import com.magednan.mortyapp.persention.characterDetails.CharacterDetailsState
import com.magednan.mortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class EpisodeDetailsViewModel @Inject constructor(
    private val allUseCases: AllUseCases
):ViewModel() {
    var state by mutableStateOf(EpisodeDetailsState())

    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }
    fun getCharacters (list: List<String>) {
        viewModelScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            allUseCases.getCharacters.invoke(list).collect{resource->
                when(resource){
                    is Resource.Success->{state=state.copy(data = resource.data)
                        Log.d("TAG", "getEpisodesgetEpisodes:${resource.toString()} ")}

                }
                }
        }
    }
}