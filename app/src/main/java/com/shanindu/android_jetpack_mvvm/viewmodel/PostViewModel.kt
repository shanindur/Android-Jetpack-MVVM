package com.shanindu.android_jetpack_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shanindu.android_jetpack_mvvm.data.repository.PostRepository
import com.shanindu.android_jetpack_mvvm.model.Post
import kotlinx.coroutines.launch

class PostViewModel : ViewModel() {
    private val postRepository = PostRepository()

    //Mutable live data to hold the list of posts
    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> get() = _posts

    //Mutable live data to hold the loading state
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    //Function to fetch the list of posts
    fun fetchPosts() {
        _isLoading.value = true

        viewModelScope.launch {
            try {
                val cards = postRepository.getPosts()
                _posts.value = cards
                _isLoading.value = false
                Log.e("fetchPosts", _posts.value.toString())
            } catch (e: Exception) {
                // Handle error
                _isLoading.value = false
                Log.e("fetchPosts ex", e.message.toString())
            }
        }
    }
}