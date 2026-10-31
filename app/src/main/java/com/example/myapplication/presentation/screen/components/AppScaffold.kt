package com.example.myapplication.presentation.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.presentation.theme.AppColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold(
    title: String,
    onBack: (() -> Unit)? = null,
    bottomBar: @Composable () -> Unit = {},
    fab: @Composable () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit) = Scaffold(
    topBar = {
        TopAppBar(title = { AppText(text = title, style = AppTextStyle.Heading, textColor = Color.White) },
        navigationIcon = {
            if (onBack != null) IconButton(onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back", tint = Color.White)
            }
        },
        actions = { OfflineBadge() }, colors = TopAppBarDefaults.topAppBarColors(containerColor = AppColors.Navy))
    },
    bottomBar = bottomBar, floatingActionButton = fab, containerColor = AppColors.Surface
) { pad ->
        Column(
            modifier = Modifier
                .padding(pad)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            content = content
        )
    }


@Composable fun OfflineBadge() = Box(Modifier.padding(end = 12.dp).background(AppColors.Success, RoundedCornerShape(14.dp)).padding(horizontal = 10.dp, vertical = 4.dp)) {
    AppText(
        text = "Offline",
        style = AppTextStyle.Caption,
        textColor = Color.White
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppScaffoldPreview() = AppScaffold(title = "Title", onBack = {}, bottomBar = { AppText(text = "Bottom bar") }, fab = { AppText(text = "FAB") }) {
    AppText(text = "Content")
}