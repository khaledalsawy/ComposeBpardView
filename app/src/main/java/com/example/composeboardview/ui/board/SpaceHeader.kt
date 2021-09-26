package com.example.composeboardview.ui.board

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.FilterAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeboardview.ui.theme.ComposeBoardViewTheme
import com.example.composeboardview.ui.theme.iconsColor

@Composable
fun SpaceToolBar(modifier: Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(

        ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = null,
            tint = iconsColor
        )

        Row {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                tint = iconsColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                Icons.Filled.FilterAlt,
                contentDescription = null,
                tint = iconsColor
            )
        }
    }
}

@Composable
fun SpaceTitle(modifier: Modifier, title: String) {
    Row(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = Modifier.align(Alignment.CenterVertically),
            style = MaterialTheme.typography.h6.copy(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            Icons.Filled.Error,
            modifier = Modifier.align(Alignment.CenterVertically),
            contentDescription = null,
            tint = iconsColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SpaceHeaderPreview() {
    ComposeBoardViewTheme {
        Column(
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 24.dp
                )
                .fillMaxWidth()
        ) {
            SpaceToolBar(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            SpaceTitle(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                title = "Tasked In"
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}
