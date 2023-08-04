package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen

sealed class HomeScreenEvents {
    object SaveColor: HomeScreenEvents()
    object SyncColor:HomeScreenEvents()
}