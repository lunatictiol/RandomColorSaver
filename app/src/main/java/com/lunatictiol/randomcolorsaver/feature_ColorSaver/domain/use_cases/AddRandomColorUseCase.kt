package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases

import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.InvalidColorException
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.repository.RandomColorRepository

class AddRandomColorUseCase(
    private val repository: RandomColorRepository
) {
    @Throws(InvalidColorException::class)
    suspend operator fun invoke(randomColor: RandomColor)
    {
        if (randomColor.color==null)
            throw InvalidColorException("color can't be empty")

        repository.insertRandomColors(randomColor)
    }
}