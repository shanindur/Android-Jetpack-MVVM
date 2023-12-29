package com.shanindu.android_jetpack_mvvm.service

import com.shanindu.android_jetpack_mvvm.model.CreditCard
import retrofit2.http.GET

interface CreditCardService {
    @GET("repos")
    suspend fun getCreditCards(): List<CreditCard>
}