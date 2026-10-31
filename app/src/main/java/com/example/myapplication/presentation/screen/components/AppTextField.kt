package com.example.myapplication.presentation.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.presentation.theme.AppColors


@Composable
fun AppTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
    error: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    password: Boolean = false,
    trailing: @Composable (() -> Unit)? = null
) {
    Column(
        modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        AppText(text = label, style = AppTextStyle.Label)

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            isError = error != null,
            shape = RoundedCornerShape(10.dp), placeholder = {
                AppText(
                    text = placeholder,
                    textColor = Color(0xFF94A3B8)
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType), trailingIcon = trailing,
            visualTransformation = if (password) PasswordVisualTransformation() else VisualTransformation.None,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AppColors.Primary,
                unfocusedBorderColor = AppColors.BorderStrong,
                errorBorderColor = AppColors.Danger,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White)
        )
        if (error != null) AppText(
            text = error,
            style = AppTextStyle.Caption,
            textColor = AppColors.Danger
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppTextFieldPreview() {
    AppTextField(
        label = "Label",
        value = "",
        onValueChange = {},
        placeholder = "Placeholder"
    )
}