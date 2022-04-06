/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aliumujib.android.stocksapp.composecommons

import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver

/**
 * Return the fully opaque color that results from compositing [onSurface] atop [surface] with the
 * given [alpha]. Useful for situations where semi-transparent colors are undesirable.
 */
public fun Colors.compositedOnSurface(alpha: Float): Color {
    return onSurface.copy(alpha = alpha).compositeOver(surface)
}

public val WindowBg: Color = Color(0xFFF3f3f3)

public val StockLightColors: Colors = lightColors(
    primary = Color.White,
    onPrimary = Color.Black
)

public val StockDarkColors: Colors = darkColors(
    primary = Color.Black,
    onPrimary = Color.White
).withBrandedSurface()

public fun Colors.withBrandedSurface(): Colors = copy(
    surface = primary.copy(alpha = 0.08f).compositeOver(this.surface),
)
