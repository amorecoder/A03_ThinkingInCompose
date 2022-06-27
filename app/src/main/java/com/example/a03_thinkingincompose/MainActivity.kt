package com.example.a03_thinkingincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

/* Important Notes about Composable
* 1. Function is fast, idempotent, and free of side-effects.
* 2. The function behaves the same way when called multiple times with the same argument, and it does
*    not use other values such as global variables or calls to random().
* 3. The function describes the UI without any side-effects, such as modifying properties or global variables.
* 4. Never depend on side-effects from executing composable functions, since a function's recomposition
*    may be skipped. If you do, users may experience strange and unpredictable behavior in your app.
*    A side-effect is any change that is visible to the rest of your app. For example, these actions are
*    all dangerous side-effects:
            i. Writing to a property of a shared object
            ii. Updating an observable in ViewModel
            iii. Updating shared preferences

* 5. Things to be aware of when you program in Compose:
        a. Composable functions can execute in any order.
        b. Composable functions can execute in parallel.
        c. Recomposition skips as many composable functions and lambdas as possible.
        d. Recomposition is optimistic and may be canceled.
        e. A composable function might be run quite frequently, as often as every frame of an animation.
*
* */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ListWithBugDemo()
            CounterButtonDemo()
        }
    }
}

