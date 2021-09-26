package com.example.composeboardview.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeboardview.ui.Board
import com.example.composeboardview.ui.BoardItem
import com.example.composeboardview.ui.theme.ComposeBoardViewTheme
import com.example.composeboardview.ui.theme.Downy
import com.example.composeboardview.ui.theme.white

@Composable
fun BoardsContainer(
    board: Board,
    onTaskClicked: (task: BoardItem) -> Unit
) {
    Column(Modifier.fillMaxHeight()) {
        Card(
            shape = CircleShape.copy(
                bottomEnd = CornerSize(12.dp),
                bottomStart = CornerSize(12.dp),
                topStart = CornerSize(6.dp),
                topEnd = CornerSize(6.dp)
            ),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .wrapContentHeight(),
            elevation = 1.dp
        ) {
            Column(
                modifier = Modifier
                    .background(white)
                    .width(280.dp)
                    .padding(bottom = 16.dp)
            ) {


                BoardHeader(board)
                Box {
                    LazyColumn(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(bottom = 40.dp)
                    ) {
                        item { Spacer(modifier = Modifier.height(4.dp)) }
                        items(board.items) {
                            Spacer(modifier = Modifier.height(2.dp))
                            BoardItem(it,onTaskClicked)
                        }
                    }

                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Icon(Icons.Default.Add, contentDescription = "", tint = Downy)
                        Text(
                            text = "Add Task",
                            style = MaterialTheme.typography.body1.copy(
                                color = Downy,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BoardsContainerPreview() {
    ComposeBoardViewTheme {
//        BoardsContainer()
    }
}