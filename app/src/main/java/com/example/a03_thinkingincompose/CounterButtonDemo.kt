package com.example.a03_thinkingincompose

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a03_thinkingincompose.ui.theme.A03_ThinkingInComposeTheme

@Composable
/* A simple example to demonstrate the UDF, Unidirectional Data Flow. States data flows down the
* hierarchy, while events from UI flows upward. */
fun CounterButtonDemo() {
    val counter = rememberSaveable { mutableStateOf(0) }
    fun incrementCounter(): ()->Unit = {
        counter.value = counter.value.inc()
        Log.i("MYTAG","running incrementCounter() outside CounterButton() Composable with counter = ${counter.value}")
    }

    A03_ThinkingInComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            CounterButton(counter, incrementCounter())
        }
    }
}
@Composable
fun CounterButton(counter: MutableState<Int>, counterIncrementer: ()->Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Log.i("MYTAG","displaying Button in Composable with counter = ${counter.value}")
        Button(onClick = counterIncrementer) {
            Text(
                text = "I have been clicked ${counter.value} times!",
                style = TextStyle(fontSize = 23.sp)
            )
        }
    }
}

