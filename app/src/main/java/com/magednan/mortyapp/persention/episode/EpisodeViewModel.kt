package com.magednan.mortyapp.persention.episode

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.mortyapp.data.mapper.*
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.useCase.AllUseCases
import com.magednan.mortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class EpisodeViewModel @Inject constructor(val allUseCases: AllUseCases):ViewModel() {
    var state by mutableStateOf(EpisodeState())
    fun getAllEpisodes(fromLocalDb:Boolean){
        if(fromLocalDb){
                viewModelScope.launch {
                    var localList=ArrayList<Episode>()
                    allUseCases.getAllFavEpisode.invoke().map {
                        localList.add(it.toEpisode())
                    }
                    if (localList.isEmpty()){
                        state=state.copy(isDbEmpty = true, errorMessage = "Empty Db please add Items")

                    }else{
                        state=state.copy(data = localList)}
                }
             }else{
            viewModelScope.launch() {
                allUseCases.getAllEpisodes.invoke().collect{item->
                    when(item){
                        is Resource.Loading->{
                            state=state.copy(isLoading = true)
                        }
                        is Resource.Success->{
                            Log.d("TAG", "getAllEpisodesVM:${item.data} ")
                          if (!item?.data?.episodeDtos?.isNullOrEmpty()){
                            state=state.copy(data = item.data.toEpisodes()!!)               //       _characterState.emit(CharacterState(data = state.data.toCharacters()))
                        }
                    }
                        is Resource.Error->{
                            state= state.copy(errorMessage = item.errorMessage)
                        }
                    }

                }}
        }
    }
    fun insertFavEpisode(episode: Episode){
        viewModelScope.launch {
            allUseCases.insertFavEpisode(episode.toEpisodeEntity())
        }
    }
    fun deleteFavEpisode(episode: Episode){
        viewModelScope.launch {
            allUseCases.deleteFavEpisode(episode.toEpisodeEntity())
        }
    }
}