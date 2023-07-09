package com.honyadew.animationtestjetpackcompose.animations.c

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateContentSizeColumn() {
    Column(
        modifier = Modifier
            .background(Color.Red)
            .padding(16.dp)
            .animateContentSize(animationSpec = tween(durationMillis = 900))
    ) {
        val showText = remember { mutableStateOf(false) }
        Button(onClick = { showText.value = !showText.value }) {
            Text(text = if (showText.value) "Collapse" else "Expand")
        }
        var string = "test"
        for (i in 0..1000) string += i.toString()
        if (showText.value) Text(text = string, Modifier.size(256.dp).padding(16.dp))
    }
}