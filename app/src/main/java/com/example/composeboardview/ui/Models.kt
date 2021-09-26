package com.example.composeboardview.ui

data class Board(
    val id: String,
    val title: String,
    val colorCode: Long,
    val description: String,
    val items: List<BoardItem>
)

data class BoardItem(
    val id: String,
    val title: String,
    val description: String,
    val boardPosition: Int,
    val itemPosition: Int
)