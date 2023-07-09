package com.honyadew.animationtestjetpackcompose.animations.d

import android.provider.SyncStateContract.Columns
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
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

@Composable
fun RotateImageByY() {
    var animated by remember { mutableStateOf(false) }
    val rotation = remember { Animatable(initialValue = 360f) }
    LaunchedEffect(animated) {
        rotation.animateTo(
            targetValue = if (animated) 0f else 360f,
            animationSpec = tween(2000)
        )
    }
    Column {
        Text(text = "Animatable. Rotate by Y axis.")
        Image(
            painter = painterResource(id = R.drawable.cat2),
            contentDescription = "Cat",
            modifier = Modifier
                .size(192.dp)
                .graphicsLayer { rotationY = rotation.value }
        )
        Button(onClick = { animated = !animated }) {
            Text(text = "Rotate!")
        }
        Divider()
    }
}