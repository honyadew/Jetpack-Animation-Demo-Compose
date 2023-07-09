package com.honyadew.animationtestjetpackcompose.animations.a

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityAdditional(){
    Column {
        val visibleTwo = remember{ mutableStateOf(true) }
        Text(text = "AnimatedVisibility Additional. Visibility is -> ${visibleTwo.value}")
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            for (i in 1..4){
                Text(text = "$i")
            }
        }
        Row(
            Modifier
                .fillMaxWidth()
                .height(64.dp), Arrangement.SpaceBetween) {
            AnimatedVisibility(
                modifier = Modifier.size(64.dp),
                visible = visibleTwo.value,
                label = "1",
                enter = expandIn(
                    expandFrom = Alignment.BottomEnd,
                    animationSpec = tween(durationMillis = 4000)
                ),
                exit = shrinkVertically(
                    shrinkTowards = Alignment.Bottom,
                    animationSpec = tween(durationMillis = 3000)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat2), contentDescription = "Cat2")
            }
            AnimatedVisibility(
                modifier = Modifier.size(64.dp),
                visible = visibleTwo.value,
                label = "2",
                enter = expandIn(
                    expandFrom = Alignment.CenterStart,
                    animationSpec = tween(durationMillis = 2000)
                ),
                exit = shrinkOut(
                    shrinkTowards = Alignment.CenterStart,
                    animationSpec = tween(durationMillis = 3000)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat2), contentDescription = "Cat2")
            }
            AnimatedVisibility(
                modifier = Modifier.size(64.dp),
                visible = visibleTwo.value,
                label = "3",
                enter = fadeIn(
                    initialAlpha = 0.5f,
                    animationSpec = tween(durationMillis = 3000)
                ),
                exit = fadeOut(
                    targetAlpha = 0.3f,
                    animationSpec = tween(durationMillis = 3000)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat2), contentDescription = "Cat2")
            }
            AnimatedVisibility(
                modifier = Modifier.size(64.dp),
                visible = visibleTwo.value,
                label = "4",
                enter = scaleIn(
                    animationSpec = tween(durationMillis = 500)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 3000)
                )
            ) {
                Image(painter = painterResource(id = R.drawable.cat2), contentDescription = "Cat2")
            }
        }
        Button(onClick = { visibleTwo.value = !visibleTwo.value }) {
            Text(text = "Toggle visibility")
        }
        Divider()
    }
}