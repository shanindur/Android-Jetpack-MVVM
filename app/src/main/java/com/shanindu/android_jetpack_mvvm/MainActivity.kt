package com.shanindu.android_jetpack_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.shanindu.android_jetpack_mvvm.ui.theme.AndroidJetpackMVVMTheme
import com.shanindu.android_jetpack_mvvm.view.MainScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.CreditCardViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CreditCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackMVVMTheme {
                MainScreen()
//                CreditCardScreen(viewModel = viewModel)
            }
        }
    }
}