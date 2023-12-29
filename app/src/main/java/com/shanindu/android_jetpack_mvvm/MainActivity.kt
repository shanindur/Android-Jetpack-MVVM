package com.shanindu.android_jetpack_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.shanindu.android_jetpack_mvvm.ui.theme.AndroidJetpackMVVMTheme
import com.shanindu.android_jetpack_mvvm.view.CreditCardScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.CreditCardViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CreditCardViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidJetpackMVVMTheme {
                CreditCardScreen(viewModel)
            }
        }
    }
}