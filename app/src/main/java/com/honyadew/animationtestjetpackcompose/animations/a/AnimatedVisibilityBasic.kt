package com.honyadew.animationtestjetpackcompose.animations.a

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandIn
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
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

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityBasic(){
    Column {

        val visibleOne = remember{ mutableStateOf(true) }
        Text(text = "AnimatedVisibility Basic. Visibility is -> ${visibleOne.value}")
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            for (i in 1..7){
                Text(text = "$i")
            }
        }
        Row(Modifier.fillMaxWidth().height(48.dp), Arrangement.SpaceBetween) {
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "1 || alpha0->100",
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "2 || slide from left(overlay)",
                enter = slideInHorizontally(),
                exit = slideOutHorizontally()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "3 || slide from top(overlay)",
                enter = slideInVertically(),
                exit = slideOutVertically()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "4 || Scaling from zero to size",
                enter = scaleIn(),
                exit = scaleOut()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "5 || slide from top left(not overlay)",
                enter = expandIn(),
                exit = shrinkOut()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "6 || slide from left (not overlay)",
                enter = expandHorizontally(),
                exit = shrinkHorizontally()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
            AnimatedVisibility(
                modifier = Modifier.size(48.dp),
                visible = visibleOne.value,
                label = "7 || slide from top (not overlay)",
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Image(painter = painterResource(id = R.drawable.cat), contentDescription = "Cat")
            }
        }
        Button(onClick = { visibleOne.value = !visibleOne.value }) {
            Text(text = "Toggle visibility")
        }
        Divider()
    }
}