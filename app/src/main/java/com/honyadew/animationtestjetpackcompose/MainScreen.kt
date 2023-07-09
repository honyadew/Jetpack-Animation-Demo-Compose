package com.honyadew.animationtestjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.honyadew.animationtestjetpackcompose.animations.AAnimation
import com.honyadew.animationtestjetpackcompose.animations.BAnimation
import com.honyadew.animationtestjetpackcompose.animations.CAnimation
import com.honyadew.animationtestjetpackcompose.animations.DAnimation
import com.honyadew.animationtestjetpackcompose.animations.EAnimation

@Composable
fun MainScreen() {
    val selectedPageIndex = remember { mutableStateOf(0)}
    val selectedTab = AnimationTab.values()[selectedPageIndex.value]

    Column(Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedPageIndex.value) {
            AnimationTab.values().forEach { tab ->
                Tab(selected = selectedTab == tab,
                    onClick = { selectedPageIndex.value = AnimationTab.values().indexOf(tab)},
                    content = {Icon(painter = painterResource(id = tab.iconId), contentDescription = "", Modifier.defaultMinSize(minHeight = 48.dp))}
                )
            }
        }
        when(selectedTab){
            AnimationTab.FIRST -> {
                AAnimation()
            }
            AnimationTab.SECOND -> {
                BAnimation()
            }
            AnimationTab.THIRD -> {
                CAnimation()
            }
            AnimationTab.FOURTH -> {
                DAnimation()
            }
            AnimationTab.FIFTH -> {
                EAnimation()
            }
        }
    }
}