package com.example.composeboardview.ui.board

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeboardview.ui.Board
import com.example.composeboardview.ui.BoardItem
import com.example.composeboardview.ui.theme.ComposeBoardViewTheme
import com.example.composeboardview.ui.theme.backGround

@Composable
fun SpaceView(boards: List<Board>, onTaskClicked: (task: BoardItem) -> Unit) {
    Column(
        modifier = Modifier.padding(
            top = 24.dp,
            bottom = 24.dp
        )
    ) {
        SpaceToolBar(Modifier.padding(start = 16.dp, end = 16.dp))
        Spacer(modifier = Modifier.height(24.dp))
        SpaceTitle(Modifier.padding(start = 16.dp, end = 16.dp), "Tasked In")
        Spacer(modifier = Modifier.height(24.dp))
        LazyRow {
            items(boards) {
                Spacer(modifier = Modifier.width(16.dp))
                BoardsContainer(it, onTaskClicked)
            }
            item { Spacer(modifier = Modifier.width(16.dp)) }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBoardViewTheme {
        Surface(
            color = backGround,
            modifier = Modifier.fillMaxHeight()
        ) {
//            SpaceView()
        }
    }
}
