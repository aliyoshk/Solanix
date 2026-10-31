package com.example.myapplication.presentation.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.theme.AppColors


@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    kind: ButtonKind = ButtonKind.Primary,
    enabled: Boolean = true
) {
    val shape = RoundedCornerShape(12.dp)
    val size = modifier.fillMaxWidth().height(48.dp)
    if (kind == ButtonKind.Secondary) {
        OutlinedButton(onClick, size, enabled, shape, border = BorderStroke(1.dp, AppColors.BorderStrong)) {
            AppText(
                text = text,
                style = AppTextStyle.Button,
                textColor = Color(0xFF334155)
            )
        }
    } else {
        Button(
            onClick,
            size,
            enabled, shape,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (kind == ButtonKind.Danger) AppColors.Danger else AppColors.Primary,
                disabledContainerColor = AppColors.BorderStrong
            )
        ) {
            AppText(
                text = text,
                style = AppTextStyle.Button,
                textColor = Color.White
            )
        }
    }
}

enum class ButtonKind { Primary, Secondary, Danger }