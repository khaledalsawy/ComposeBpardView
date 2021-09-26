package com.example.composeboardview.ui.board

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composeboardview.ui.Board
import com.example.composeboardview.ui.theme.white

@Composable
fun BoardHeader(board: Board) {
    Surface(
        modifier = Modifier.clip(RoundedCornerShape(6.dp))
    ) {
        Text(
            text = board.title,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.body2.copy(color = white),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(board.colorCode))
                .padding(12.dp)
        )
    }
}