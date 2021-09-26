package com.example.composeboardview.ui.board

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeboardview.R
import com.example.composeboardview.ui.BoardItem
import com.example.composeboardview.ui.theme.ComposeBoardViewTheme
import com.example.composeboardview.ui.theme.itemBackGround

@Composable
fun BoardItem(
    boardItem: BoardItem,
    onTaskClicked: (task: BoardItem) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable {
                onTaskClicked(boardItem)
            },
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(itemBackGround)
                .padding(8.dp)

        ) {
            Box {
                Text(
                    text = boardItem.title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(end = 32.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Image(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 8.dp),
                    contentDescription = null,
                    painter = painterResource(R.drawable.ic_high_pr)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.user1),
                    modifier = Modifier.size(32.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Khaled Alsawy",
                    fontWeight = FontWeight.Medium,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun BoardItemPreview() {
    ComposeBoardViewTheme {
        Column(
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 24.dp
                )
                .fillMaxWidth()
        ) {

//            BoardItem(BoardItem("1", "Test", "ttt",1))
        }

    }
}

