package com.example.myapplication.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.presentation.screen.components.AppButton
import com.example.myapplication.presentation.screen.components.AppText
import com.example.myapplication.presentation.screen.components.AppTextField
import com.example.myapplication.presentation.screen.components.AppTextStyle


@Composable
fun LoginScreen(
    navController: NavController
) {
    Scaffold(
    ) { innerPadding ->
        LoginUI(
            modifier = Modifier
                .padding(innerPadding),
            onSignInClick = {}
        )
    }
}


@Composable
fun LoginUI(
    modifier: Modifier = Modifier,
    username: String = "",
    onUserChanged: (String) -> Unit = {},
    password: String = "",
    onPasswordChanged: (String) -> Unit = {},
    onSignInClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppText(
            modifier = Modifier
                .background(
                    color = Color(0xFF1D4ED8),
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 30.dp, vertical = 20.dp),
            text = "S",
            textColor = Color.White,
            style = AppTextStyle.Large
        )

        Spacer(Modifier.height(16.dp))

        AppText(
            text = "ShopStock",
            style = AppTextStyle.Heading,
        )

        Spacer(Modifier.height(6.dp))

        AppText(
            text = "Laptop stock, sales and debts",
            style = AppTextStyle.BodyLight
        )

        Spacer(Modifier.height(35.dp))

        AppTextField(
            label = "Email or username",
            value = username,
            onValueChange = onUserChanged,
        )

        Spacer(Modifier.height(18.dp))

        AppTextField(
            label = "Password",
            password = true,
            value = password,
            onValueChange = onPasswordChanged,
        )

        Spacer(Modifier.height(35.dp))

        AppButton(
            text = "Sign in",
            onClick = onSignInClick
        )

        Spacer(Modifier.height(30.dp))

        AppText(
            text = "Works without internet",
            style = AppTextStyle.Caption,
            textColor = Color(0xFF16A34A)
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginUIPreview() {
    LoginUI(onSignInClick = {})
}