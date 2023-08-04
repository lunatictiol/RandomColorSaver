package com.lunatictiol.randomcolorsaver.feature_ColorSaver.presentation.home_screen

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.InvalidColorException
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.model.RandomColor
import com.lunatictiol.randomcolorsaver.feature_ColorSaver.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
        object SaveColor : UiEvent()


    }

    private val _state = mutableStateOf<HomeScreenState>(HomeScreenState())
    private var _syncCounter = mutableStateOf<Int>(0)
    val state: State<HomeScreenState> = _state
    private var getRandomColorJob: Job? = null

    init {
        getRandomColor()
    }


    fun onEvent(event: HomeScreenEvents) {
        when (event) {
            is HomeScreenEvents.SaveColor -> {
                viewModelScope.launch {
                    try {
                        useCases.addRandomColorUseCase(
                            randomColor = RandomColor(
                                color = generateRandomColorHexCode(),
                                timestamp = System.currentTimeMillis()
                            )
                        )


                    } catch (e: InvalidColorException) {


                    }
                }
            }

            is HomeScreenEvents.SyncColor -> {
               viewModelScope.launch {
                      try {


                          useCases.saveToFireBaseUseCase()
                          _syncCounter.value = 0
                          _state.value = state.value.copy(
                              syncCounter = _syncCounter.value
                          )
                      }
                      catch (e:Exception){
                          Log.e("save",e.message.toString())
                      }



               }

            }

        }

    }


    fun generateRandomColorHexCode(): String {
        val random = Random.Default
        val color =
            random.nextInt(0x1000000) // Generates a random number between 0 and 0xFFFFFF (inclusive)
        return String.format("#%06X", color)
    }


    fun getRandomColor() {
        getRandomColorJob?.cancel()
        getRandomColorJob = useCases.getColorListUseCase().onEach { randomColors ->
            _state.value = state.value.copy(
                colorList = randomColors,
                syncCounter = _syncCounter.value++
            )

        }.launchIn(
            viewModelScope
        )
    }


}