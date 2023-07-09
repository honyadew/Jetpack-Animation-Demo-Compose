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
fun CrossfadeImageText(){
    Column {
        val state = remember { mutableStateOf<CatTextState>(CatTextState.Cat) }
        Text(text = "Crossfade Image-Text")
        Crossfade(targetState = state.value) { currentState ->
            when (currentState) {
                CatTextState.Cat -> {
                    Image(
                        painter = painterResource(id = R.drawable.cat3),
                        contentDescription = "Cat", Modifier.size(256.dp)
                    )
                }

                CatTextState.Text -> {
                    var string = "test"
                    for (i in 0..1000) string += i.toString()
                    Text(text = string, Modifier.size(256.dp))
                }
            }
        }
        Button(onClick = {
            state.value = if (state.value == CatTextState.Cat) CatTextState.Text else CatTextState.Cat
        }) {
            Text(text = "Toggle Cat-O-Text")
        }
        Divider()
    }
}


private sealed class CatTextState {
    object Cat : CatTextState()
    object Text : CatTextState()
}