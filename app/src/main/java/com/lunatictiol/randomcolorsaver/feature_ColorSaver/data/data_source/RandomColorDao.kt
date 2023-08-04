package com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import kotlinx.coroutines.flow.Flow

@Dao
interface RandomColorDao {
    @Query("SELECT * FROM randomColor")
    fun getRandomColors(): Flow<List<RandomColor>>
    @Query("SELECT * FROM randomColor WHERE id = :id")
    suspend fun getRandomColorById(id:Int): RandomColor?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRandomColor(randomColor: RandomColor)


}
