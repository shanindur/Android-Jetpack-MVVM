package com.shanindu.android_jetpack_mvvm.data.repository

import com.shanindu.android_jetpack_mvvm.model.Post
import com.shanindu.android_jetpack_mvvm.service.RetrofitInstance

class PostRepository {
    private val postService = RetrofitInstance.postService

    suspend fun getPosts(): List<Post> {
        return postService.getPosts()
    }

    suspend fun getPostDetails(): Post {
        return postService.getPostDetails()
    }
}