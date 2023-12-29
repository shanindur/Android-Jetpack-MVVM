package com.shanindu.android_jetpack_mvvm.data.repository

import com.shanindu.android_jetpack_mvvm.model.CreditCard
import com.shanindu.android_jetpack_mvvm.service.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): List<CreditCard> {
        return creditCardService.getCreditCards()
    }
}