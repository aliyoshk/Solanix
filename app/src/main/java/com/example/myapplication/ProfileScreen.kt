package com.example.myapplication

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
        var anotherText = ""

        var text by remember { mutableStateOf("") }
        var buttonClickCount by remember { mutableStateOf(0) }

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

                Text(
                    if (text.equals("c")) "Carl Johnson" else "Unknown User"
                )

                Text(
                    if (text == "c") "carl@example.com" else "unknown@yahoo.com"
                )
            }

            Column(
                Modifier.verticalScroll(rememberScrollState())
            ) {

                Spacer(Modifier.height(38.dp))

                ProfileList("Account settings")

                Spacer(Modifier.height(12.dp))

                ProfileList("Notifications")

                Spacer(Modifier.height(12.dp))

                ProfileList("Security")

                Spacer(Modifier.height(12.dp))

                ProfileList("About TaskFlow")

                Spacer(Modifier.height(38.dp))

                TextField(
                    value = text,
                    onValueChange = { value ->
                        Log.d("ProfileScreen", "Value changed to $value")
                        anotherText = value
                        text = value
                    }
                )

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = { buttonClickCount++ }
                ) {
                    Log.d("ProfileScreen", "Button click count equal $buttonClickCount")
                    Text(
                        text = if (buttonClickCount == 1) "Log In" else "Log Out"
                    )
                }

                Spacer(Modifier.height(12.dp))

                ButtonSamples()
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


@Composable
fun ButtonSamples() {
    Column(Modifier.padding(20.dp)) {
        Button(
            onClick = {}
        ) {
            Text("Button")
        }

        Spacer(Modifier.height(30.dp))

        OutlinedButton(onClick = {}) {
            Text("Outlined Button")
        }

        Spacer(Modifier.height(30.dp))

        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }

        Spacer(Modifier.height(30.dp))

        FilledTonalButton(onClick = {}) {
            Text("Filled Tonal Button")
        }

        Spacer(Modifier.height(30.dp))

        TextButton(onClick = {}) {
            Text("Text Button")
        }

        Spacer(Modifier.height(30.dp))

        FloatingActionButton(
            onClick = {},
            shape = CircleShape
        ) {
            Image(painter = painterResource(id = R.drawable.add),
                contentDescription = "FAB"
            )
        }

        Spacer(Modifier.height(30.dp))

        ExtendedFloatingActionButton(onClick = {}) {
            Text("Extended")
        }

        Spacer(Modifier.height(30.dp))

        IconButton(onClick = {}) {
            Text("Icon")
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}