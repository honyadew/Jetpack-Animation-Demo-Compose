package com.honyadew.animationtestjetpackcompose.animations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honyadew.animationtestjetpackcompose.animations.b.CrossfadeImageImage
import com.honyadew.animationtestjetpackcompose.animations.b.CrossfadeImageText

@Composable
fun BAnimation(){
    Column(modifier = Modifier.fillMaxSize()){
        CrossfadeImageImage()
        CrossfadeImageText()
    }
}