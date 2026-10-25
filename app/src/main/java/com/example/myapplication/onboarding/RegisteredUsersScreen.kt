package com.example.myapplication.onboarding

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.myapplication.UserEntity


@Composable
fun RegisteredUsersScreen(
    navController: NavController
) {
    val context = LocalContext.current
    val db = Room.databaseBuilder(context, AppDatabase::class.java, "app.db").build()

//    var users by remember { mutableStateOf<List<UserEntity>>(emptyList()) }

    val viewModel: OnboardingViewModel = viewModel(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return OnboardingViewModel(db.userDao()) as T
            }
        }
    )
    val users = viewModel.registeredUsers



//    LaunchedEffect(Unit) {
//        viewModel.fetchUsers {
//            if (it.isNotEmpty()) {
//                users = it
//            }
//        }
//    }

    Scaffold(
    ) { innerPadding ->
        RegisteredUsersUI(
            modifier = Modifier.padding(innerPadding),
            users = users,
            onBack = { navController.navigateUp() }
        )
    }
}


@Composable
fun RegisteredUsersUI(
    modifier: Modifier = Modifier,
    users: List<UserEntity> = emptyList(),
    onBack: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        users.forEachIndexed { index, entity ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    entity.id.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
                
                Text(
                    entity.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )

                Text(
                    entity.email,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp
                )
            }   
        }

        Spacer(Modifier.weight(1f))

        Button(onClick = { onBack() }) {
            Text("Go Back")
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisteredUsersPreview() {
    RegisteredUsersUI(users = listOf(
        UserEntity(
            1,
            "Joel Salako",
            "joel@example.com",
            password = ""
        )
    ))
}