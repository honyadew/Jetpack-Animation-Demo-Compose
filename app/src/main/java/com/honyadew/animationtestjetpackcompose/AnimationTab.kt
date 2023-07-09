package com.honyadew.animationtestjetpackcompose

import androidx.annotation.DrawableRes

enum class AnimationTab(
    @DrawableRes val iconId: Int
) {
    FIRST(iconId = R.drawable.ic_first),
    SECOND(iconId = R.drawable.ic_second),
    THIRD(iconId = R.drawable.ic_third),
    FOURTH(iconId = R.drawable.ic_forth),
    FIFTH(iconId = R.drawable.ic_fifth),
}