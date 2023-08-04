package com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases

data class UseCases(
    val getColorListUseCase: GetColorListUseCase,
    val addRandomColorUseCase: AddRandomColorUseCase,
    val saveToFireBaseUseCase: SaveToFireBaseUseCase
)
