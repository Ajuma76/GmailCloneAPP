package com.example.gmailclone.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.AddAPhoto
import androidx.compose.material.icons.rounded.Mail
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuClass(
    val icon: ImageVector,
    val title: String) {

    object Mail : BottomMenuClass(Icons.Rounded.Mail,"Mail")
    object Meet : BottomMenuClass(Icons.Rounded.Videocam, "Meet")
}