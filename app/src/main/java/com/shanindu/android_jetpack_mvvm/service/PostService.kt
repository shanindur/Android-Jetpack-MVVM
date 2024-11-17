package com.shanindu.android_jetpack_mvvm.service

import com.shanindu.android_jetpack_mvvm.model.Post
import retrofit2.http.GET

interface PostService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}