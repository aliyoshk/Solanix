package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun WelcomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopBarUI(
                title = stringResource(R.string.stay_on_top_of_everything),
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(stringResource(R.string.task_flow_practical_app))

            Spacer(Modifier.height(56.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = colorResource(R.color.light_purple),
                        shape = RoundedCornerShape(16.dp)
                    )
                    .padding(start = 28.dp, end = 28.dp, top = 38.dp, bottom = 68.dp)
            ) {
                TaskFlowCard(stringResource(R.string.review_project_brief))

                Spacer(Modifier.height(16.dp))

                TaskFlowCard(stringResource(R.string.review_project_brief))
            }

            Spacer(Modifier.height(131.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {},
                colors = ButtonColors(
                    containerColor = colorResource(R.color.dark_purple),
                    contentColor = colorResource(R.color.white),
                    disabledContainerColor = colorResource(R.color.black),
                    disabledContentColor = colorResource(R.color.white)
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(stringResource(R.string.get_started))
            }
        }
    }
}


@Composable
fun TaskFlowCard(text: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = colorResource(R.color.white),
                shape = RoundedCornerShape(26.dp)
            )
            .padding(vertical = 16.dp, horizontal = 48.dp),
        text = text
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen()
}

