package com.belajar.trystate.viewmodel

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.belajar.trystate.model.WellnessTask

class WellnessViewModel : ViewModel() {
    private val _task = getWellnessTask().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _task

    fun remove(item: WellnessTask){
        _task.remove(item)
    }

}

private fun getWellnessTask() = List(30){ i -> WellnessTask(i, "Task $i") }