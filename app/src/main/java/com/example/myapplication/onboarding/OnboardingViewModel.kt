package com.example.myapplication.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.UserDao
import com.example.myapplication.UserEntity
import kotlinx.coroutines.launch


class OnboardingViewModel(private val dao: UserDao) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    var registeredUsers by mutableStateOf<List<UserEntity>>(emptyList())
    var error by mutableStateOf("")
        private set

    init {
        viewModelScope.launch {
            val users = dao.getAllUsers()
            if (users.isNotEmpty()) {
                registeredUsers = users
            } else {
                error = "No users found"
            }
        }
    }


    fun onRegister(user: UserEntity, onSuccess: () -> Unit) {
        viewModelScope.launch {
            dao.register(user)
            onSuccess()
        }
    }

    fun onLogin(
        email: String,
        password: String,
        onSuccess: (String) -> Unit
    ) {
        viewModelScope.launch {
            val user = dao.login(email = email, password = password)
            if (user != null) {
                onSuccess(user.email)
            } else {
                error = "Invalid credentials"
            }
        }
    }
}