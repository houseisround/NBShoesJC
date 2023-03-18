package com.example.nbshoesjetpackcompose.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Shoes(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    @StringRes val information: Int
)
