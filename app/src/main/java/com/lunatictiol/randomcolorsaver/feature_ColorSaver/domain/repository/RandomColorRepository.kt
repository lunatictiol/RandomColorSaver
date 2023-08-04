package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository

import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import kotlinx.coroutines.flow.Flow

interface RandomColorRepository {

    fun getRandomColors(): Flow<List<RandomColor>>

    suspend fun getRandomColorById(id: Int): RandomColor?

    suspend fun insertRandomColors(randomColor:RandomColor)


}
