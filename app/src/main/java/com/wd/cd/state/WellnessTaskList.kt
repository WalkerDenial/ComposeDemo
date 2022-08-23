package com.wd.cd.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

/**
 *
 * @Author Walker Denial
 * @Email WalkerDenial@gmail.com
 * @Time Created at 2022/8/23 19:13.
 */
private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }

@Composable
fun WellnessTasksList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask> = remember {
        getWellnessTasks()
    }
) {
    LazyColumn(modifier = modifier) {
        items(list) { task ->
            WellnessTaskItem(taskName = task.label)
        }
    }
}