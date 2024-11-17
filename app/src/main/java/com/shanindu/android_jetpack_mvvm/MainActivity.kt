package com.shanindu.android_jetpack_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.shanindu.android_jetpack_mvvm.navigation.AppNavigation
import com.shanindu.android_jetpack_mvvm.ui.LoginScreen
import com.shanindu.android_jetpack_mvvm.ui.theme.AndroidJetpackMVVMTheme
import com.shanindu.android_jetpack_mvvm.ui.MainScreen
import com.shanindu.android_jetpack_mvvm.viewmodel.PostViewModel

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