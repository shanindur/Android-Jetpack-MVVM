package com.shanindu.android_jetpack_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanindu.android_jetpack_mvvm.data.repository.CreditCardRepository
import com.shanindu.android_jetpack_mvvm.model.CreditCard
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val creditCardRepository = CreditCardRepository()

    private val _creditCards = MutableLiveData<List<CreditCard>>()
    val creditCards: LiveData<List<CreditCard>> = _creditCards

    fun fetchCreditCards() {
        viewModelScope.launch {
            try {
                val cards = creditCardRepository.getCreditCards()
                _creditCards.value = cards
                Log.e("FetchCreditCard", _creditCards.value.toString());
            } catch (e: Exception) {
                // Handle error
                Log.e("FetchCreditCard ex", e.message.toString());
            }
        }
    }
}