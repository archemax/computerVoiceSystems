package com.example.computervoicesystems.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.computervoicesystems.presentation.navigation.NavigationComponent
import com.example.computervoicesystems.ui.theme.ComputerVoiceSystemsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComputerVoiceSystemsTheme {
             NavigationComponent()
            }
        }
    }
}

