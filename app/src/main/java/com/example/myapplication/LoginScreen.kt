package com.example.myapplication

import android.content.Context
import android.util.Log
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.navigation.NavController
import com.example.myapplication.navigation.HomeScreen
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(
    ) { innerPadding ->
        val context = LocalContext.current
        val dataStoreManager = remember { DataStoreManager(context) }
        val scope = rememberCoroutineScope()

        val savedUsername = dataStoreManager.username.collectAsState("")

        Log.d("Saved Username", "${savedUsername.value}")

        var username by rememberSaveable { mutableStateOf<String?>(null) }
        var password by rememberSaveable { mutableStateOf("") }

        LoginUI(
            modifier = Modifier.padding(innerPadding),
            userName = username ?: savedUsername.value.toString(),
            onUsernameChange = { username = it },
            password = password,
            onPasswordChange = { password = it },
            onButtonClick = {
                scope.launch {
                    dataStoreManager.saveLogin(username ?: "", password)
                    Log.d("Saved Username", "Username saved: $username")
                }
                navController.navigate(HomeScreen)
            }
        )
    }
}


@Composable
fun LoginUI(
    modifier: Modifier = Modifier,
    userName: String,
    onUsernameChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onButtonClick: () -> Unit = {}
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
            value = userName,
            onValueChange = onUsernameChange,
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
            value = password,
            onValueChange = onPasswordChange,
        )

        Spacer(Modifier.height(36.dp))

        Button(
            onClick = onButtonClick,
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
fun LoginUIPreview() {
    LoginUI(
        userName = "", onUsernameChange = {},
        password = "", onPasswordChange = {}
    )
}