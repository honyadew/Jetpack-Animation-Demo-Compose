package com.honyadew.animationtestjetpackcompose.animations

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.honyadew.animationtestjetpackcompose.animations.c.AnimateContentSizeColumn
import com.honyadew.animationtestjetpackcompose.animations.c.AnimateContentSizeRow

@Composable
fun CAnimation(){
    Column(modifier = Modifier.fillMaxSize()){
        AnimateContentSizeColumn()
        AnimateContentSizeRow()
    }
}