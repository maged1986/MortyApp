package com.magednan.mortyapp.data.mapper

import com.magednan.mortyapp.data.dtos.character.CharacterDto
import com.magednan.mortyapp.data.dtos.character.CharactersResponse
import com.magednan.mortyapp.data.dtos.episode.EpisodeDto
import com.magednan.mortyapp.data.dtos.episode.EpisodeResponse
import com.magednan.mortyapp.data.dtos.location.LocationDto
import com.magednan.mortyapp.data.dtos.location.LocationResponse
import com.magednan.mortyapp.data.local.entities.CharacterEntity
import com.magednan.mortyapp.data.local.entities.EpisodeEntity
import com.magednan.mortyapp.data.local.entities.LocationEntity
import com.magednan.mortyapp.domain.models.Character
import com.magednan.mortyapp.domain.models.Episode
import com.magednan.mortyapp.domain.models.Location


fun CharactersResponse.toCharacters(): List<com.magednan.mortyapp.domain.models.Character> {
    var list=ArrayList<Character>()
    this.results.forEach {
        list.add(it.toCharacter())
    }
    return list as List<com.magednan.mortyapp.domain.models.Character>
}
fun CharacterDto.toCharacter():com.magednan.mortyapp.domain.models.Character{
    return this.location?.name?.let {
        com.magednan.mortyapp.domain.models.Character(
            id = this.id,
            name=this.name,
            episode=this.episode,
            status =this.status,
            species = this.species,
            type=this.type,
            gender = this.gender,
            origin = this.origin?.name,
            location = it,
            image_url = this.image
        )
    }!!
}
fun CharacterEntity.toCharacter():com.magednan.mortyapp.domain.models.Character{
    return com.magednan.mortyapp.domain.models.Character(
        id = this.id,
        name=this.name,
        episode=this.episode,
        status =this.status,
        species = this.species,
        type=this.type,
        gender = this.gender,
        origin = this.origin,
        location = this.location,
        image_url = this.image_url
    )
}fun Character.toCharacterEntity():CharacterEntity{
    return CharacterEntity(
        id = this.id,
        name=this.name,
        episode=this.episode,
        status =this.status,
        species = this.species,
        type=this.type,
        gender = this.gender,
        origin = this.origin,
        location = this.location,
        image_url = this.image_url
    )
}

fun LocationResponse.toLocation():List<com.magednan.mortyapp.domain.models.Location>{
    var list=ArrayList<Location>()
    this.locationDtos.forEach {
        list.add(it.toLocation())
    }
    return list as List<com.magednan.mortyapp.domain.models.Location>
}
fun LocationDto.toLocation():Location{
    return Location(
        created = this.created,
        dimension = this.dimension,
        id = this.id,
        name = this.name,
        residents = this.residents,
        type = this.type,
        url = this.url
    )
}

fun LocationEntity.toLocation():Location{
    return Location(
        created = this.created,
        dimension = this.dimension,
        id = this.id,
        name = this.name,
        residents = this.residents,
        type = this.type,
        url = this.url
    )
}

fun Location.toLocationEntity():LocationEntity{
    return LocationEntity(
        created = this.created,
        dimension = this.dimension,
        id = this.id,
        name = this.name,
        residents = this.residents,
        type = this.type,
        url = this.url)
}

fun EpisodeResponse.toEpisodes():List<Episode>{
    val list=ArrayList<Episode>()
    if (!this.episodeDtos.isNullOrEmpty()){
    this.episodeDtos.forEach {
        if(it !== null){
        list.add(it.toEpisode())
    }}}
    return list
}
fun EpisodeDto.toEpisode():Episode{
    return Episode(
        air_date = this.air_date,
        characters = this.characters,
        created = this.created,
        episode = this.episode,
        id = this.id,
        name = this.name,
        url = this.url)
}

fun EpisodeEntity.toEpisode():Episode{
    return Episode(
       air_date =  this.air_date,
        characters = this.characters,
        created = this.created,
        episode = this.episode,
        id=this.id,
        name = this.name,
        url = this.url)
}

fun Episode.toEpisodeEntity():EpisodeEntity{
    return EpisodeEntity(air_date =  this.air_date,
        characters = this.characters,
        created = this.created,
        episode = this.episode,
        id=this.id,
        name = this.name,
        url = this.url)
}