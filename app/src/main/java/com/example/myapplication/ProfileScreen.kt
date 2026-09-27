package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(25.dp )
        ) {
            // Circle

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    modifier = Modifier
                        .background(
                            color = colorResource(R.color.light_purple),
                            shape = CircleShape
                        )
                        .border(
                            width = 2.dp,
                            color = Color.Red,
                            shape = CircleShape
                        )
                        .padding(40.dp)
                    ,
                    text = "C",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(7.dp))

                Text("Carl Johnson")

                Text("carl@example.com")
            }

            Spacer(Modifier.height(38.dp))

            ProfileList("Account settings")

            Spacer(Modifier.height(12.dp))

            ProfileList("Notifications")

            Spacer(Modifier.height(12.dp))

            ProfileList("Security")

            Spacer(Modifier.height(12.dp))

            ProfileList("About TaskFlow")

            Spacer(Modifier.height(38.dp))

            Button(

                onClick = {}
            ) {
                Text("Log Out")
            }
        }
    }

}

@Composable
fun ProfileList(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .border(
                1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(16.dp)
    )
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}