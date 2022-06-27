package com.magednan.mortyapp.persention.location

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.magednan.mortyapp.data.mapper.*
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location
import com.magednan.mortyapp.domain.useCase.AllUseCases
import com.magednan.mortyapp.persention.episode.EpisodeState
import com.magednan.mortyapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(val allUseCases: AllUseCases):ViewModel() {
    var state by mutableStateOf(LocationState())
    fun getAllEpisodes(fromLocalDb:Boolean){
        if(fromLocalDb){
            viewModelScope.launch {
                var localList=ArrayList<Location>()
                allUseCases.getAllFavLocations.invoke().map {
                    localList.add(it.toLocation())
                }
                if (localList.isEmpty()){
                    state=state.copy(isDbEmpty = true, errorMessage = "Empty Db please add Items")

                }else{
                    state=state.copy(data = localList)}
            }
        }else{
            viewModelScope.launch() {
                allUseCases.getAllLocations.invoke().collect{item->
                    when(item){
                        is Resource.Loading->{
                            state=state.copy(isLoading = true)
                        }
                        is Resource.Success->{
                            Log.d("TAG", "getAllEpisodesVM:${item.data} ")
                            if (!item?.data?.locationDtos?.isNullOrEmpty()){
                                state=state.copy(data = item.data.toLocation()!!)               //       _characterState.emit(CharacterState(data = state.data.toCharacters()))
                            }
                        }
                        is Resource.Error->{
                            state= state.copy(errorMessage = item.errorMessage)
                        }
                    }

                }}
        }
    }
    fun insertLocation(location: Location){
        viewModelScope.launch {
            allUseCases.insertLocation(location.toLocationEntity())
        }
    }
    fun deleteLocation(location: Location){
        viewModelScope.launch {
            allUseCases.deleteLocation(location.toLocationEntity())
        }
    }
}