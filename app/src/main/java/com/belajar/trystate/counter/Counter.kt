package com.belajar.trystate.counter

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun StatefulCounter(modifier: Modifier = Modifier){
    var count by rememberSaveable { mutableStateOf(0) }
    
    StatelessCounter(count = count, onIncrement = { count+=2 }, modifier = modifier)
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier
){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0){
            Text("you've had $count glasses")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 100,
            modifier = Modifier
        ){
            Text(text = "Click Me +1")
        }

    }
}