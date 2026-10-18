package com.example.myapplication

import android.widget.Button
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun LoginScreen() {
    Scaffold() { innerPadding ->
        LoginUI(modifier = Modifier.padding(innerPadding))
    }
}


@Composable
fun LoginUI(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "S",
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .background(Color(0xFF1D4ED8), RoundedCornerShape(20.dp))
                .padding(30.dp),
        )

        Spacer(Modifier.height(14.dp))

        Text(
            text = "ShopStock",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.height(4.dp))

        Text(
            "Laptop stock, sales and debts",
            fontWeight = FontWeight.Light
        )

        Spacer(Modifier.height(35.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            text = "Email or username",
            fontWeight = FontWeight.Light
        )

        AppInputField(
            value = "",
            onValueChange = {},
        )

        Spacer(Modifier.height(18.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            text = "Password",
            fontWeight = FontWeight.Light
        )

        AppInputField(
            value = "",
            onValueChange = {},
        )

        Spacer(Modifier.height(36.dp))

        Button(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign in")
        }

        Spacer(Modifier.height(30.dp))

        Text(
            text = "Works offline. Data syncs when online.",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF16A34A)
        )
    }
}


@Composable
fun AppInputField(
    value: String = "",
    onValueChange: (String) -> Unit = {},
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
    )
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AppInputFieldPreview() {
    Column(
        modifier = Modifier
            .padding(50.dp)
            .fillMaxWidth()

    ) {
        AppInputField()
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun LoginUIPreview() {
    LoginUI()
}