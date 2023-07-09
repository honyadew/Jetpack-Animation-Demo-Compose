package com.honyadew.animationtestjetpackcompose.animations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honyadew.animationtestjetpackcompose.animations.d.RotateImageByY
import com.honyadew.animationtestjetpackcompose.animations.d.AnimatebleOthers
import com.honyadew.animationtestjetpackcompose.animations.d.SpinImageByXYZ

@Composable
fun DAnimation(){
    Column(modifier = Modifier.fillMaxSize()){
        RotateImageByY()
        SpinImageByXYZ()
        AnimatebleOthers()
    }
}