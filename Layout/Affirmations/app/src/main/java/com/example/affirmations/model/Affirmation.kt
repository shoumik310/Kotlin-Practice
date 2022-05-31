package com.example.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 *   Forms the template for data (DTO)
 */
data class Affirmation(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
