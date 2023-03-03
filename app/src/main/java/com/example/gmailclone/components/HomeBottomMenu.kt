package com.example.gmailclone.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.gmailclone.model.BottomMenuClass

@Composable
fun HomeBottomMenu(){
    val item = listOf(
        BottomMenuClass.Mail,
        BottomMenuClass.Meet,

    )

    BottomNavigation(backgroundColor = Color.LightGray,
        contentColor = Color.Black) {
        item.forEach {
            BottomNavigationItem(
                label = {Text(text = it.title)},
                alwaysShowLabel = false,
                selected = false,
                onClick = { /*TODO*/ },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title )}
            )
        }
    }
}