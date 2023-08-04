package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen

import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor

data class HomeScreenState(
    val colorList: List<RandomColor> = emptyList(),
    var syncCounter:Int = 0
)
