package com.honyadew.animationtestjetpackcompose.animations.b

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.R

@Composable
fun CrossfadeImageImage(){
    Column {
        val state = remember { mutableStateOf<CatState>(CatState.CatOne) }
        Text(text = "Crossfade Image-Image")
        Crossfade(targetState = state.value) { currentState ->
            when (currentState) {
                CatState.CatOne -> {
                    Image(
                        painter = painterResource(id = R.drawable.cat),
                        contentDescription = "Cat", Modifier.size(256.dp)
                    )
                }

                CatState.CatTwo -> {
                    Image(
                        painter = painterResource(id = R.drawable.cat2),
                        contentDescription = "Cat", Modifier.size(128.dp)
                    )
                }
            }
        }
        Button(onClick = {
            state.value = if (state.value == CatState.CatOne) CatState.CatTwo else CatState.CatOne
        }) {
            Text(text = "Toggle Cat")
        }
        Divider()
    }
}

private sealed class CatState {
    object CatOne : CatState()
    object CatTwo : CatState()
}