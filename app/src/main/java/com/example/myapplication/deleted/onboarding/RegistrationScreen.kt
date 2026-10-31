package com.example.myapplication.deleted.onboarding

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.Room
import com.example.myapplication.deleted.AppDatabase
import com.example.myapplication.deleted.UserEntity
import com.example.myapplication.deleted.navigation.LoginScreen


@Composable
fun RegistrationScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()
//    val scope = rememberCoroutineScope()

    val viewModel: OnboardingViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return OnboardingViewModel(db.userDao()) as T
            }
        }
    )

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(

    ) { innerPadding ->
        RegistrationUI(
            modifier = Modifier.padding(innerPadding),
            name = name,
            onNameChange = { name = it },
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            onRegisterClick = {
                val user = UserEntity(name = name, email = email, password = password)
                viewModel.onRegister(user) {
                    navController.navigate(LoginScreen)
                }
//                scope.launch {
//                    val user = UserEntity(name = name, email = email, password = password)
//                    db.userDao().register(user)
//                    navController.navigate(LoginScreen)
//                }
            },
            onLogin = { navController.navigate(LoginScreen) }
        )
    }
}


@Composable
fun RegistrationUI(
    modifier: Modifier = Modifier,
    name: String = "",
    onNameChange: (String) -> Unit = {},
    email: String = "",
    onEmailChange: (String) -> Unit = {},
    password: String = "",
    onPasswordChange: (String) -> Unit = {},
    onRegisterClick: () -> Unit = {},
    onLogin: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Registration Screen",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(30.dp))

        Text("Enter your details")

        Spacer(Modifier.height(30.dp))

        OutlinedTextField(
            label = { Text("Name") },
            onValueChange = onNameChange,
            value = name
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            label = { Text("email") },
            onValueChange = onEmailChange,
            value = email
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            label = { Text("Password") },
            onValueChange = onPasswordChange,
            value = password
        )

        Spacer(Modifier.height(50.dp))

        Button(onClick = onRegisterClick) {
            Text("Register")
        }

        Spacer(Modifier.height(20.dp))

        Text(
            "Already have an account? Sign in",
            modifier = Modifier.clickable(onClick = { onLogin() }),
            color = Color(0xFF16A34A),
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationUIPreview() {
    RegistrationUI()
}