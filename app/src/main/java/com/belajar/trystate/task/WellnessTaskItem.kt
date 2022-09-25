package com.belajar.trystate.task

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.belajar.trystate.model.WellnessTask

@Composable
fun WellnessTaskList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(
        modifier = modifier
    ){
        items(items = list, key = { task -> task.id }){ task ->
            WellnessTaskItem(taskName = task.label, onClose = {onCloseTask(task)})
        }
    }
}


//statefull
@Composable
fun WellnessTaskItem(taskName: String, onClose: () -> Unit,  modifier: Modifier = Modifier){
    var checkedState by rememberSaveable{ mutableStateOf(false) }
    
    WellnessTaskItem(
        taskName = taskName,
        checked = checkedState,
        onCheckedChange = {newValue -> checkedState = newValue},
        onClose = onClose,
        modifier = modifier
    )
}

//stateless
@Composable
fun WellnessTaskItem(
    taskName: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    onClose: () -> Unit,
    modifier: Modifier
){
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(modifier = Modifier
            .weight(1f)
            .padding(16.dp),
        text = taskName
        )
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}