package com.honyadew.animationtestjetpackcompose.animations.d

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.R

@Composable
fun AnimatebleOthers(){
    var scaled by remember { mutableStateOf(false) }
    val scale = remember { Animatable(initialValue = 1f) }
    LaunchedEffect(scaled) {
        scale.animateTo(
            targetValue = if (scaled) 10f else 1f,
            animationSpec = tween(2000)
        )
    }
    var alphaChange by remember { mutableStateOf(false)}
    val alphaLayer = remember { Animatable(initialValue = 1f)}
    LaunchedEffect(alphaChange) {
        alphaLayer.animateTo(
            targetValue = if (alphaChange) 0f else 1f,
            animationSpec = tween(2000)
        )
    }
    var translated by remember { mutableStateOf(false)}
    val trans = remember { Animatable(initialValue = 100f)}
    LaunchedEffect(translated) {
        trans.animateTo(
            targetValue = if (translated) 0f else 500f,
            animationSpec = tween(2000)
        )
    }
    Column {
        Text(text = "Animatable. Others.")
        Image(
            painter = painterResource(id = R.drawable.cat3),
            contentDescription = "Cat",
            modifier = Modifier
                .size(128.dp)
                .graphicsLayer {
                    scaleY = scale.value
                    alpha = alphaLayer.value
                    translationX = trans.value
                }
        )
        Row {
            Button(onClick = { scaled = !scaled }) {
                Text(text = "Scale")
            }
            Button(onClick = { alphaChange = !alphaChange }) {
                Text(text = "Alpha")
            }
            Button(onClick = { translated = !translated }) {
                Text(text = "TranslationX")
            }
        }
        Divider()
    }
}