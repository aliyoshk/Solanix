package com.example.myapplication.presentation.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


@Composable
fun AppText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = null,
    textColor: Color = colorResource(R.color.black),
    style: AppTextStyle = AppTextStyle.Body
) {
    Text(
        modifier = modifier,
        text = text,
        textAlign = textAlign,
        fontSize = style.size.sp,
        color = textColor,
        fontWeight = style.weight
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTextPreview() {
    AppText(modifier = Modifier, text = "Preview Text")
}