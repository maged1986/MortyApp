package com.magednan.mortyapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


@ProvidedTypeConverter
class Converters {

    @TypeConverter
    fun fromList(list: List<String>):String{
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(listStr:String):List<String>{
        val listType=object : TypeToken<List<String>?>() {}.type
        return Gson().fromJson(listStr,listType)
    }
}

