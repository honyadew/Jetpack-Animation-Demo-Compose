package com.honyadew.animationtestjetpackcompose.animations.a

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.EaseInCubic
import androidx.compose.animation.core.EaseInElastic
import androidx.compose.animation.core.EaseInExpo
import androidx.compose.animation.core.EaseInOutBounce
import androidx.compose.animation.core.EaseInQuad
import androidx.compose.animation.core.EaseInQuint
import androidx.compose.animation.core.EaseOutBounce
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.EaseOutElastic
import androidx.compose.animation.core.EaseOutExpo
import androidx.compose.animation.core.EaseOutQuad
import androidx.compose.animation.core.EaseOutQuint
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
fun AnimatedVisibilityEasing(){
    Column {
        val visibleThree = remember{ mutableStateOf(true) }
        Text(text = "AnimatedVisibility Easing. Visibility is -> ${visibleThree.value}")
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            for (i in 1..7){
                Text(text = "$i")
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(48.dp), Arrangement.SpaceBetween) {
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "1",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInCubic)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutCubic)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "2",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInExpo)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutExpo)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "3",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInQuint)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutQuint)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "4",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInOutBounce)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInOutBounce)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "5",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInBounce)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutBounce)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "6",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInElastic)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutElastic)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleThree.value,
                label = "7",
                enter = slideInVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseInQuad)
                ),
                exit = slideOutVertically(
                    animationSpec = tween(durationMillis = 3000, easing = EaseOutQuad)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat3), contentDescription = "Cat3")
            }
        }
        Button(onClick = { visibleThree.value = !visibleThree.value }) {
            Text(text = "Toggle visibility")
        }
        Divider()
    }
}