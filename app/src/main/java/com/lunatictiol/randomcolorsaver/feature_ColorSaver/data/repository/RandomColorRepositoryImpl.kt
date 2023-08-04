package com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.repository

import com.lunatictiol.randomcolorsaver.feature_ColorSaver.data.data_source.RandomColorDao
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository.RandomColorRepository
import kotlinx.coroutines.flow.Flow

class RandomColorRepositoryImpl(
    private val dao:RandomColorDao
):RandomColorRepository {
    override fun getRandomColors(): Flow<List<RandomColor>> {
    return dao.getRandomColors()
    }

    override suspend fun getRandomColorById(id: Int): RandomColor? {
        return dao.getRandomColorById(id)
    }

    override suspend fun insertRandomColors(randomColor: RandomColor) {
        dao.insertRandomColor(randomColor)
    }
}