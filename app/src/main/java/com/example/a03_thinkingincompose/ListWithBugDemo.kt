package com.example.a03_thinkingincompose

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/* An example of a bad composable due to updating data resulting in potential side effects. */
@Composable
fun ListWithBugDemo() {
    val list = List<String>(4) { i -> "List item number $i" }
    ListWithBug(myList = list)
}
@Composable
fun ListWithBug(myList: List<String>) {
    var items = 0

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            for(item in myList) {
                Text("Item: $item")

                // updating this variable that is used in another composable, Text(), could
                // result in unpredictable side effect since the Column() composable where
                // the update happens are ran in parallel with the Text() composable.
                items++
            }
        }

        Text(text = "Count: $items")
    }
}

