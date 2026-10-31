package com.example.myapplication.deleted

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch


@Composable
fun HomeScreen() {
    Scaffold() { innerPadding ->
        val context = LocalContext.current
        val dataStoreManager = remember { DataStoreManager(context) }
        val scope = rememberCoroutineScope()

        val savedUsername = dataStoreManager.username.collectAsState("")
        val password = dataStoreManager.password.collectAsState("")
        val isLoggedIn = dataStoreManager.isLoggedIn.collectAsState(false)

        HomeUI(
            modifier = Modifier.padding(innerPadding),
            name = "Username: ${savedUsername.value.toString()} - Password ${password.value.toString()}",
            onLogout = {
                scope.launch {
                    dataStoreManager.deleteLogin()
                }
            }
        )
    }
}


@Composable
fun HomeUI(
    modifier: Modifier = Modifier,
    name: String,
    onLogout: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "ShopStock",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Button(onClick = onLogout) {
                Text("Logout")
            }
        }

        Spacer(Modifier.height(15.dp))

        Text(
            text = "Good morning, $name",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )

        Spacer(Modifier.height(8.dp))

        HomeCard()

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DetailCard(
                title = "Total sales",
                value = "₦4,250,000",
                valueTextColor = Color(0xFF1D4ED8)
            )

            DetailCard(
                title = "Total profit",
                value = "₦620,000",
                valueTextColor = Color(0xFF1D4ED8)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            DetailCard(
                title = "Total sales",
                value = "₦4,250,000",
                valueTextColor = Color(0xFF1D4ED8)
            )

            Spacer(Modifier.weight(1f))

            DetailCard(
                title = "Total profit",
                value = "₦620,000",
                valueTextColor = Color(0xFF1D4ED8)
            )
        }

        Spacer(modifier = Modifier.height(13.dp))

        Text(
            text = "Recent sales",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        RecentItemCard(
            name = "Product A",
            amount = "₦250,000",
            specification = "2 units",
            status = "Completed"
        )
    }
}

@Composable
fun HomeCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1D4ED8), RoundedCornerShape(10.dp))
            .padding(16.dp)

    ) {
        Text(
            text = "Today's sales",
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            text = "₦4,250,000",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Text(
            text = "12 sales · profit ₦620,000",
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        )
    }
}

@Composable
fun DetailCard(
    title: String,
    value: String,
    valueTextColor: Color = Color.Black
) {
    Column(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Text(
            text = title,
            color = Color.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = valueTextColor,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
}

@Composable
fun RecentItemCard(
    name: String,
    amount: String,
    specification: String,
    status: String,
    statusTextColor: Color = Color(0xFF166534),
    statusBg: Color = Color(0xFFDCFCE7)
) {
    Column(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(10.dp))
            .border(1.dp, Color(0xFFE2E8F0), RoundedCornerShape(10.dp))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )

            Text(
                modifier = Modifier.padding(end = 10.dp),
                text = amount,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = specification,
                fontSize = 12.sp,
                fontWeight = FontWeight.Light
            )

            Text(
                text = status,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = statusTextColor,
                modifier = Modifier
                    .background(statusBg, RoundedCornerShape(10.dp))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            )
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun HomeUIPreview() {
    HomeUI(name = "Aliyu")
}