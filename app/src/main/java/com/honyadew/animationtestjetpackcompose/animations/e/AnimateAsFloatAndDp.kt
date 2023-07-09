package com.honyadew.animationtestjetpackcompose.animations.e

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AnimateAsFloatAndDp() {
    //Same method to animate Float; Color; Dp; Size; Offset.
    //And same for Rect; Int; IntOffset; IntSize. (but not sure)
    var animatedFloat by remember { mutableStateOf(false) }
    val rotationFloatState = animateFloatAsState(
        targetValue = if (animatedFloat) 0f else 360f,
        animationSpec = tween(2000)
    )
    var animatedDp by remember { mutableStateOf(false)}
    val resizeDpState = animateDpAsState(
        targetValue = if (animatedDp) 0.dp else 192.dp,
        animationSpec = tween(2000)
    )

    Column {
        Text(text = "Animatable. Animate Dp and Flot")
        Image(
            painter = painterResource(id = R.drawable.cat),
            contentDescription = "Cat",
            modifier = Modifier
                .size(resizeDpState.value)
                .graphicsLayer {
                    rotationY = rotationFloatState.value
                    shape = RoundedCornerShape(resizeDpState.value)
                }
        )
        Row {
            Button(onClick = { animatedFloat = !animatedFloat }) {
                Text(text = "Animate Float")
            }
            Button(onClick = { animatedDp = !animatedDp }) {
                Text(text = "Animate Dp")
            }
        }
        Divider()
    }
}

