package com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor


@Database(
    entities = [RandomColor::class],
    version = 1
)
abstract class RandomColorDatabase: RoomDatabase() {
    abstract val randomColorDao: RandomColorDao
    companion object{
        const val DATABASE_NAME = "randomColor_db"
    }
}