package com.example.jetpack_test1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.jetpack_test1.ui.theme.Jetpack_test1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Jetpack_test1Theme {
                // A surface container using the 'background' color from the theme
Nav()
            }
        }
    }

}
