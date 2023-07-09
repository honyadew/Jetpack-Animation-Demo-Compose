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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.R
import kotlinx.coroutines.delay

@Composable
fun SpinImageByXYZ(){
    var reset by remember { mutableStateOf(false) }
    var animatedX by remember { mutableStateOf(false) }
    var animatedY by remember { mutableStateOf(false) }
    var animatedZ by remember { mutableStateOf(false) }
    val rotationByX = remember { Animatable(initialValue = 0f) }
    val rotationByY = remember { Animatable(initialValue = 0f) }
    val rotationByZ = remember { Animatable(initialValue = 0f) }

    LaunchedEffect(animatedX) {
        while (animatedX){
            rotationByX.animateTo(
                targetValue = rotationByX.targetValue + 360f,
                animationSpec = tween(2000)
            )
            delay(100)
        }
    }
    LaunchedEffect(animatedY) {
        while (animatedY){
            rotationByY.animateTo(
                targetValue = rotationByY.targetValue + 360f,
                animationSpec = tween(2000)
            )
            delay(100)
        }
    }
    LaunchedEffect(animatedZ) {
        while (animatedZ){
            rotationByZ.animateTo(
                targetValue = rotationByZ.targetValue + 360f,
                animationSpec = tween(2000)
            )
            delay(100)
        }
    }
    LaunchedEffect(reset) {
        rotationByX.animateTo(targetValue = 0f)
        rotationByY.animateTo(targetValue = 0f)
        rotationByZ.animateTo(targetValue = 0f)
    }

    Column {
        Text(text = "Animatable. Rotate by XYZ axis.")
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Cat",
            modifier = Modifier
                .size(192.dp)
                .graphicsLayer {
                    rotationX = rotationByX.value
                    rotationY = rotationByY.value
                    rotationZ = rotationByZ.value
                }
        )
        Row {
            Button(onClick = { animatedX = !animatedX }) {
                Text(text = "Rotate X")
            }
            Button(onClick = { animatedY = !animatedY }) {
                Text(text = "Rotate Y")
            }
            Button(onClick = { animatedZ = !animatedZ }) {
                Text(text = "Rotate Z")
            }
            Button(onClick = {
                reset = !reset
                animatedX = false
                animatedY = false
                animatedZ = false
            }) {
                Text(text = "Reset")
            }
        }

        Divider()
    }
}