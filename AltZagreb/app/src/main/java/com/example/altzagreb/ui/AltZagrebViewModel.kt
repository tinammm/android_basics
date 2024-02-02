package com.example.altzagreb.ui

import androidx.lifecycle.ViewModel
import com.example.altzagreb.model.AltInstitution
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AltZagrebViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(AltZagrebUiState())
    val uiState : StateFlow<AltZagrebUiState> = _uiState

    fun setCurrentScreen(navIcon : AltZagrebScreens){
        _uiState.update {currentState ->
            currentState.copy(
                currentScreen = navIcon
            )
        }
    }

    fun setCurrentAltInstitution(altInstitution: AltInstitution){
        _uiState.update {currentState ->
            currentState.copy(
                currentAltListItem = altInstitution
            )
        }
    }
}