package com.example.myapplication.presentation.screen.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.myapplication.presentation.theme.AppColors

enum class AppTextStyle(val size: Int, val weight: FontWeight, val color: Color) {
    Large(40, FontWeight.Bold, AppColors.Text),
    Heading(22, FontWeight.Bold, AppColors.Text),
    Title(16, FontWeight.Bold, AppColors.Text),
    Body(14, FontWeight.Normal, AppColors.Text),
    BodyLight(14, FontWeight.Light, AppColors.Text),
    Caption(12, FontWeight.Normal, AppColors.Muted),
    Label(12, FontWeight.Medium, AppColors.Muted),
    Money(24, FontWeight.Bold, AppColors.Text),
    Button(15, FontWeight.SemiBold, AppColors.Text)
}