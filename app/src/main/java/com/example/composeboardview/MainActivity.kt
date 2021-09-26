package com.example.composeboardview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.MutableLiveData
import com.example.composeboardview.ui.Board
import com.example.composeboardview.ui.BoardItem
import com.example.composeboardview.ui.board.SpaceView
import com.example.composeboardview.ui.theme.ComposeBoardViewTheme
import com.example.composeboardview.ui.theme.backGround

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBoardViewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = backGround,
                    modifier = Modifier.fillMaxHeight()
                ) {
                    generateDummy()
                    RenderState()
                }
            }
        }
    }

    @Composable
    private fun RenderState() {
        val data: State<List<Board>> = liveData.observeAsState(emptyList())
        SpaceView(data.value, ::onTaskClicked)
    }

    private fun onTaskClicked(boardItem: BoardItem) {
        val board = liveData.value?.get(boardItem.boardPosition)
        val list = board!!.items.toMutableList()
        list.removeAt(boardItem.itemPosition)
        val newBoard = board.copy(items = list)
        val newData = liveData.value!!.toMutableList()
        newData[boardItem.boardPosition] = newBoard
        val items = newData[1].items.toMutableList()
        items.add(boardItem)
        val inProgress = newData[1].copy(
            items = items
        )
        newData[1] = inProgress
        liveData.value = newData
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBoardViewTheme {
//        SpaceView()
    }
}


private val liveData = MutableLiveData<List<Board>>(emptyList())

fun generateDummy(): List<Board> {
    val data = listOf(
        Board("1", "TO-DO", 0xFF4FAFC0, "Test", generateDummyTasks(10, 0)),
        Board("2", "IN PROGRESS", 0xFFF05128, "Test", generateDummyTasks(2, 1)),
        Board("3", "COMPLETED", 0xFF0D7433, "Test", generateDummyTasks(5, 2)),
        Board("4", "HOLD", 0xFF474747, "Test", generateDummyTasks(2, 3)),
        Board("5", "ENDED", 0xFF272727, "Test", generateDummyTasks(40, 4))
    )
    liveData.value=data
    return data

}

fun generateDummyTasks(count: Int, boardPosition: Int): List<BoardItem> {
    val tasks: MutableList<BoardItem> = mutableListOf()
    for (i in 0..count) {
        tasks.add(
            BoardItem(
                i.toString(),
                "Task Task title   $i -- $boardPosition",
                "Test",
                boardPosition,
                i
            )
        )
    }
    return tasks
}