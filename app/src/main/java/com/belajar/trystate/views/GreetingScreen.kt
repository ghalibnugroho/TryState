package com.belajar.trystate.views

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.belajar.trystate.counter.StatefulCounter
import com.belajar.trystate.model.WellnessTask
import com.belajar.trystate.task.WellnessTaskList
import com.belajar.trystate.viewmodel.WellnessViewModel

@Composable
fun GreetingScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    Column(modifier = Modifier) {
        StatefulCounter()

        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) })

//        val list = remember { getWellnessTask().toMutableStateList() }
//        WellnessTaskList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}
//private fun getWellnessTask() = List(30){ i -> WellnessTask(i, "Task $i") }
