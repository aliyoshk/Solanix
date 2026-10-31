package com.example.myapplication.deleted

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R


@Composable
fun CustomerScreenScreen(name: String? = "", age: String? = "") {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
    ) { paddingValue ->
        CustomerScreenUI(
            modifier = Modifier.padding(paddingValue),
            name = name.orEmpty(),
            age = age.orEmpty()
        )
    }
}



@Composable
fun CustomerScreenUI(
    name: String,
    age: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val users = listOf(
            Triple<String, String, String> ("Carl Benz", "carl@gmail.com", "Active"),
            Triple<String, String, String> ("Joel Salako", "joel@yahoo.com", "Active"),
            Triple<String, String, String> ("Charles Jones", "jones@ymail.com", "Inactive"),
            Triple<String, String, String> ("Joe Ben", "joe@gmail.com", "Active"),
            Triple<String, String, String> ("Yusuf Benz", "benz@gmail.com", "Inactive"),
            Triple<String, String, String> ("Carl Benz", "carl@gmail.com", "Active"),
            Triple<String, String, String> ("Joel Salako", "joel@yahoo.com", "Active"),
            Triple<String, String, String> ("Charles Jones", "jones@ymail.com", "Inactive"),
            Triple<String, String, String> ("Joe Ben", "joe@gmail.com", "Active"),
            Triple<String, String, String> ("Yusuf Benz", "benz@gmail.com", "Inactive"),
        )

        Text("Name: $name, Age: $age")

        Spacer(Modifier.height(30.dp))

        LazyRow() {
            items(users.size) { index ->
                val user = users[index]
                Text("Users - ${user.first}")
            }
        }

        Spacer(Modifier.height(30.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(users.size) { index ->
                val user = users[index]
                CustomerCard(user)
            }
        }
    }
}

@Composable
fun CustomerCard(user: Triple<String, String, String>) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = null
        )

        Spacer(Modifier.width(30.dp))

        Column() {
            Text(user.first, fontWeight = FontWeight.Bold)
            Text(user.second, fontWeight = FontWeight.Light)
        }

        Spacer(Modifier.weight(1f))

        Text("Status - ${user.third}")
    }
}



@Composable
@Preview(showBackground = true, showSystemUi = true)
fun CustomerScreenUIPreview() {
    CustomerScreenUI("", "")
}