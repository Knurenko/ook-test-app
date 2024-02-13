package com.example.ooktestapp.presentation.ui.compose.elements

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ooktestapp.presentation.ui.theme.AppTheme

/**
 * @author Knurenko Bogdan 13.02.2024
 */

@Composable
fun AppBar() = Row(
    modifier = Modifier
        .fillMaxWidth()
        .height(52.dp)
        .background(color = AppTheme.colors.accent),
    horizontalArrangement = Arrangement.Center
) {
    // just a title at the moment
    Text(
        modifier = Modifier.align(Alignment.CenterVertically),
        text = "OOK Group Test App",
        style = TextStyle(
            color = AppTheme.colors.background,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    )
}

@Preview(name = "light")
@Preview(name = "dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun Preview() = AppTheme {
    AppBar()
}