package com.honyadew.animationtestjetpackcompose.animations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honyadew.animationtestjetpackcompose.animations.e.AnimateAsFloatAndDp

@Composable
fun EAnimation(){
    Column(modifier = Modifier.fillMaxSize()){
        AnimateAsFloatAndDp()
    }
}