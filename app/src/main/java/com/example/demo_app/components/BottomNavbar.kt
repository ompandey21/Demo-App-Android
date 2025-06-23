package com.example.demo_app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun BottomNavBar(navController: NavController, padding: PaddingValues) {
    val selectedItem = remember {
        mutableIntStateOf(0)
    }
    val brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFFFFA726), Color(0xFFFF5722))
    )

    val items = listOf("Home", "Search", "Profile", "Settings")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Search,
        Icons.Default.AccountCircle,
        Icons.Default.Settings
    )

    BottomNavigation(
        contentColor = Color.White,
        modifier = Modifier.background(brush)
            .fillMaxHeight(.2f)
            .fillMaxWidth()
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(imageVector = icons[index], contentDescription = item) },
                label = { Text(text = item) },
                selected = selectedItem.value == index,
                onClick = { selectedItem.value = index },
                alwaysShowLabel = true,
                modifier = Modifier.background(brush)
            )
        }
    }
}

