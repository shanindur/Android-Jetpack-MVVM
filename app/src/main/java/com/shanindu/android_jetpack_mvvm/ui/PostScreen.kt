package com.shanindu.android_jetpack_mvvm.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.shanindu.android_jetpack_mvvm.model.Post
import com.shanindu.android_jetpack_mvvm.ui.component.LoadingScreen
import com.shanindu.android_jetpack_mvvm.util.DateTime
import com.shanindu.android_jetpack_mvvm.viewmodel.PostViewModel

@Composable
fun PostScreen(postViewModel: PostViewModel, navController: NavHostController) {
    val posts by postViewModel.posts.observeAsState(emptyList())
    val isLoading by postViewModel.isLoading.observeAsState(true)

    LaunchedEffect(Unit) {
        postViewModel.fetchPosts()
    }

    if (isLoading) {
        LoadingScreen()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Posts",
                        style = MaterialTheme.typography.headlineLarge
                    )
                }
            }
            items(posts) { card ->
                PostItem(card, navController)
            }
        }
    }

}

@Composable
fun PostItem(post: Post, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(),
        colors = CardDefaults.cardColors(Color.LightGray),
        onClick = {navController.navigate("details/${post.id}")}
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = post.title.uppercase(),
                style = MaterialTheme.typography.headlineLarge,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Created At: ${DateTime.getFormattedDate("2024-12-01T00:00:00Z")}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}