package com.shanindu.android_jetpack_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.shanindu.android_jetpack_mvvm.navigation.AppNavigation
import com.shanindu.android_jetpack_mvvm.ui.theme.AndroidJetpackMVVMTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidJetpackMVVMTheme {
                AppNavigation()
            }
        }
    }
}