package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases

import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository.RandomColorRepository
import kotlinx.coroutines.flow.Flow

class GetColorListUseCase(
    private val repository: RandomColorRepository
) {
    operator fun invoke():Flow<List<RandomColor>>{
        return repository.getRandomColors()

    }

}