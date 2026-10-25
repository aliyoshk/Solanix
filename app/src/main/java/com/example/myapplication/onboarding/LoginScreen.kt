package com.example.myapplication.onboarding

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.example.myapplication.AppDatabase
import com.example.myapplication.DataStoreManager
import com.example.myapplication.navigation.RegisteredUsersScreen
import com.example.myapplication.navigation.RegistrationScreen
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(navController: NavController) {
    Scaffold(
    ) { innerPadding ->
        val context = LocalContext.current
//        val dataStoreManager = remember { DataStoreManager(context) }
        val db = Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()
//        val scope = rememberCoroutineScope()

//        val savedUsername = dataStoreManager.username.collectAsState("")

        val viewModel: OnboardingViewModel = viewModel(
            factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return OnboardingViewModel(db.userDao()) as T
                }
            }
        )



        var username by rememberSaveable { mutableStateOf<String?>(null) }
        var password by rememberSaveable { mutableStateOf("") }

        LoginUI(
            modifier = Modifier.padding(innerPadding),
            userName = username ?: "",
            onUsernameChange = { username = it },
            password = password,
            onPasswordChange = { password = it },
            onRegisterClick = { navController.navigate(RegistrationScreen) },
            onButtonClick = {
                viewModel.onLogin(
                    email = username ?: "",
                    password = password,
                    onSuccess = { navController.navigate(RegisteredUsersScreen) }
                )
//                scope.launch {
////                    dataStoreManager.saveLogin(username ?: "", password)
////                    Log.d("Saved Username", "Username saved: $username")
//
//                    val user = db.userDao().login(username ?: "", password)
//                    if (user != null) {
//                        navController.navigate(RegisteredUsersScreen)
//                    } else {
//                        Log.d("Login", "Invalid credentials for user: $username")
//                    }
//                }
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
    onRegisterClick: () -> Unit = {},
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
            modifier = Modifier.clickable(onClick = { onRegisterClick() }),
            text = "Don't have an account? Register",
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