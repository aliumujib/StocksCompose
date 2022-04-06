package com.aliumujib.android.stocksapp.composecommons

import android.widget.ToggleButton
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/***
 * Copy paste coding enabled by: https://stackoverflow.com/questions/67023923/materialbuttontogglegroup-in-jetpack-compose
 */

@Composable
public fun ToggleButtonGroup(selectedIndex: Int, items: List<String>, indexChanged: (Int) -> Unit) {
    val cornerRadius = 8.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.weight(1f))

        items.forEachIndexed { index, item ->
            OutlinedButton(
                onClick = { indexChanged(index) },
                shape = when (index) {
                    // left outer button
                    0 -> RoundedCornerShape(topStart = cornerRadius, topEnd = 0.dp, bottomStart = cornerRadius, bottomEnd = 0.dp)
                    // right outer button
                    items.size - 1 -> RoundedCornerShape(topStart = 0.dp, topEnd = cornerRadius, bottomStart = 0.dp, bottomEnd = cornerRadius)
                    // middle button
                    else -> RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
                },
                border = BorderStroke(1.dp, if(selectedIndex == index) { Color.DarkGray } else { Color.DarkGray.copy(alpha = 0.35f)}),
                colors = if(selectedIndex == index) {
                    // selected colors
                    ButtonDefaults.outlinedButtonColors(backgroundColor = Color.White, contentColor = Color.DarkGray)
                } else {
                    // not selected colors
                    ButtonDefaults.outlinedButtonColors(backgroundColor = Color.White, contentColor = Color.DarkGray)
                },
            ) {
                Text(
                    text = item,
                    color = if(selectedIndex == index) { Color.DarkGray } else { Color.DarkGray.copy(alpha = 0.3f) },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}
