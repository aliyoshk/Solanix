package com.example.myapplication

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = { TopBarUI(title = "Analytics") }
                ) { innerPadding ->
                    ScreenContent(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun ScreenContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
    ) {
        Text(
            text = "Your productivity this week",
            color = Color(0xFF70757D),
            fontSize = 14.sp
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp)
        ) {
            Text(
                text = "COMPLETION RATE",
                color = Color(0xFF8A8F97),
                fontSize = 15.sp
            )
            Text(
                text = "82%",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "+8% from last week",
                color = Color(0xFF2E8B57),
                fontSize = 12.sp
            )
        }

        Spacer(Modifier.height(29.dp))

        Text(
            text = "This week"
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Completed tasks"
                )
                Spacer(Modifier.width(58.dp))
                Text(
                    text = "Pending tasks"
                )
            }

            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "32"
                )
                Spacer(Modifier.width(168.dp))
                Text(
                    text = "7"
                )
            }
        }

        Spacer(Modifier.height(29.dp))

        Text(
            text = "Categories"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Work"
            )

            Text(
                text = "18"
            )
        }

        Spacer(Modifier.height(12.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 24.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Personal"
            )

            Text(
                text = "14"
            )
        }
    }
}

@Composable
fun Bell() {
    val toggler = false

    Box(
        modifier = Modifier.wrapContentWidth()
    ) {
        Image(
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp),
            painter = painterResource(id = R.drawable.doorbell),
            contentDescription = "Bell Icon",
        )

        Box(
            modifier = Modifier
                .offset(x = -8.dp, y = 10.dp)
                .padding(8.dp)
                .size(24.dp)
                .background(
                    color = Color.Red,
                    shape = RoundedCornerShape(12.dp)
                )
                .align(Alignment.TopEnd)
        )
    }
}


@Composable
fun TopBarUI(title: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text(
            text = title,
            color = Color(0xFF17191C),
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ScreenContentPreview() {
    MyApplicationTheme {
        //ScreenContent()
        Bell()
    }
}