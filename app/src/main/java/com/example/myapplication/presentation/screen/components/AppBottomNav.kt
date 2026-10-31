package com.example.myapplication.presentation.screen.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AppBottomNav(
    selected: String,
    onSelect: (String) -> Unit
) = NavigationBar(containerColor = Color.White) {
    listOf(
        Triple("home", "Home", Icons.Filled.Home),
        Triple("stock", "Stock", Icons.AutoMirrored.Filled.List),
        Triple("sell", "Sell", Icons.Filled.Add),
        Triple("debts", "Debts", Icons.Filled.ShoppingCart),
        Triple("more", "More", Icons.Filled.Menu)
    ).forEach { (route, label, icon) ->
        NavigationBarItem(
            selected = selected == route,
            onClick = { onSelect(route) },
            icon = { Icon(icon, label) },
            label = { Text(label) }
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AppBottomNavPreview() {
    AppBottomNav(selected = "home", {})
}