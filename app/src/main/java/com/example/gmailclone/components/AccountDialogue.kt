package com.example.gmailclone.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PersonAddAlt
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.gmailclone.R
import com.example.gmailclone.model.Account

@Composable
fun AccountsDialog(openDialog: MutableState<Boolean>){
    Dialog(onDismissRequest = { openDialog.value = false },
        properties = DialogProperties(dismissOnClickOutside = false) ) {
        AccountsDialogUI(openDialog = openDialog)
    }
}

@Composable
fun AccountsDialogUI(openDialog: MutableState<Boolean>){
   Card() {
       Column(modifier = Modifier
           .background(Color.White)
           .padding(bottom = 16.dp)) {
           
           Row(modifier = Modifier
               .fillMaxWidth()
               .padding(top = 10.dp), verticalAlignment = Alignment.CenterVertically) {
               IconButton(onClick = { openDialog.value = false },) {
                   Icon(imageVector = Icons.Default.Close, contentDescription = "Close")
               }
               Image(painter = painterResource(id = R.drawable.google_2015_logo_svg),
                   contentDescription = "Google Image", modifier = Modifier
                       .size(30.dp)
                       .weight(1.0f))
           }

           AccountItem(account = accountList[0])
           Row(
               modifier = Modifier.fillMaxWidth(),
               horizontalArrangement = Arrangement.SpaceEvenly
           ) {
               Card(modifier = Modifier.requiredWidth(150.dp),
                    shape = RoundedCornerShape(50.dp),
                    border = BorderStroke(1.dp, color = Color.Gray)) {
                   Text(text = "Google Account",
                       modifier = Modifier.padding(8.dp), textAlign = TextAlign.Center)
               }
               Spacer(modifier = Modifier.width(10.dp))
           }
           Divider(modifier = Modifier.padding(top = 16.dp))

           Column {
               AccountItem(account = accountList[1])
               AccountItem(account = accountList[2])

               AddAccount(icon = Icons.Default.PersonAddAlt, title = "Add another account")
               AddAccount(icon = Icons.Outlined.ManageAccounts, title = "Manage Accounts on this device")

               Divider(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))

               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.SpaceEvenly
               ) {
                   Text(text = "Privacy Policy")
                   Card(modifier = Modifier
                       .padding(top = 10.dp)
                       .size(5.dp)
                       .clip(CircleShape),
                       backgroundColor = Color.Black) {

                   }
                   Text(text = "Terms of service")
               }
           }
       }
   }
}

@Composable
fun AccountItem(account: Account){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 16.dp)) {

        if (account.icon != null){
            Image(painter = painterResource(id = account.icon),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(color = Color.Gray))
        }else{
            Card(modifier = Modifier
                .padding(end = 1.dp)
                .clip(CircleShape)
                .size(30.dp),
                backgroundColor = Color.Gray) {
                Text(text = account.userName[0].toString(),
                    textAlign = TextAlign.Center, modifier = Modifier.padding(5.dp))
            }
        }

        Column(modifier = Modifier
            .weight(2.0f)
            .padding(start = 16.dp, bottom = 16.dp)){
            Text(text = account.userName, fontWeight = FontWeight.Bold)
            Text(text = account.email)
        }
        Text(text = "${account.unreadMails}+", modifier = Modifier.padding(end = 16.dp))
    }
}

@Composable
fun AddAccount(icon: ImageVector, title:String){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 10.dp)) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = icon,
                contentDescription = "",
                modifier = Modifier.padding(bottom = 8.dp))
        }

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 8.dp, start = 6.dp )
        )
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview
@Composable
fun AccountsDialogUIPreview(){
    AccountsDialogUI(openDialog = mutableStateOf(false))
}