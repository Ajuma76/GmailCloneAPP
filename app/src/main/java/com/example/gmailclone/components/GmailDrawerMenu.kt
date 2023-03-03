package com.example.gmailclone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.model.DrawerMenuData

@Composable
fun GmailDrawerMenu(scrollState: ScrollState){

    val menuList = listOf(
        DrawerMenuData.Divider,
        DrawerMenuData.AllInboxes,
        DrawerMenuData.Divider,
        DrawerMenuData.Primary,
        DrawerMenuData.Social,
        DrawerMenuData.Promotions,
        DrawerMenuData.HeaderOne,
        DrawerMenuData.Starred,
        DrawerMenuData.Snoozed,
        DrawerMenuData.Important,
        DrawerMenuData.Sent,
        DrawerMenuData.Schedule,
        DrawerMenuData.Outbox,
        DrawerMenuData.Draft,
        DrawerMenuData.AllMails,
        DrawerMenuData.HeaderTwo,
        DrawerMenuData.Calender,
        DrawerMenuData.Contacts,
        DrawerMenuData.Divider,
        DrawerMenuData.Settings,
        DrawerMenuData.Help,
    )


    Column(Modifier.verticalScroll(scrollState)) {
        Text(text = "Gmail",
            fontWeight = FontWeight.ExtraBold,
            color = Color.Red,
            fontSize = 23.sp,
            modifier = Modifier.padding(start = 20.dp, top = 20.dp))
        menuList.forEach{
            item ->

            when{
                item.isDivider->{
                    Divider(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp))
                }
                item.isHeader->{
                    Text(text = item.title!!, fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 20.dp, top = 20.dp, start = 20.dp))
                }else -> {
                  MailDrawerItem(item = item)
                }
            }


        }
    }
}

@Composable
fun MailDrawerItem(item: DrawerMenuData){
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .padding(top = 16.dp)) {
        Image(imageVector = item.icon!!,
            contentDescription = item.title!!,
            modifier = Modifier.weight(0.5f))
        
        Text(text = item.title,
            modifier = Modifier.weight(2.0f))
    }
}