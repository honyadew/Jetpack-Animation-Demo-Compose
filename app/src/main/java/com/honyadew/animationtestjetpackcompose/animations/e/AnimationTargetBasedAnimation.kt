package com.honyadew.animationtestjetpackcompose.animations.e

import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.R

@Composable
fun AnimationTargetBasedAnimation() {
    var state by remember { mutableStateOf(false)}
    val anim = remember {
        //The most Low-level API in Jetpack Compose.
        TargetBasedAnimation(
            animationSpec = tween(durationMillis = 2000),
            typeConverter = Float.VectorConverter,
            initialValue = 50f,
            targetValue = 200f
        )
    }
    //Long recommendation because amount of frame can be big
    var playTime by remember { mutableStateOf(0L)}
    var animationValue by remember { mutableStateOf(0)}

    LaunchedEffect(state){
        val startTime = withFrameNanos { it }
        do {
            playTime = withFrameNanos { it } - startTime
            animationValue = anim.getValueFromNanos(playTime).toInt()
        } while (!anim.isFinishedFromNanos(playTime))
    }
    Column {
        Text(text = "Animation.TargetBasedAnimation")
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Cat",
            Modifier.size(animationValue.dp)
        )
        Button(onClick = {state = !state}) {
            Text(text = "Animate!")
        }
    }
}