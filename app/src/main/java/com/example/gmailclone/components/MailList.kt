package com.example.gmailclone.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gmailclone.model.MailData

@Composable
fun MailListssss(paddingValues: PaddingValues, scrollState: ScrollState){
    Box(modifier = Modifier.padding(paddingValues)){
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(10.dp).scrollable(scrollState, Orientation.Vertical)){
            items(mailList){
                mailData->
                    MailItem(mailData = mailData)
            }
        }
    }

}

@Composable
fun MailItem(mailData: MailData, modifier: Modifier = Modifier){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Card(modifier = Modifier
            .padding(end = 8.dp)
            .clip(CircleShape)
            .size(40.dp),
            backgroundColor = Color.Gray) {
            Text(text = mailData.username[0].toString(),
                textAlign = TextAlign.Center, modifier = Modifier.padding(8.dp))
        }
        Column(Modifier.weight(2.0f)) {
            Text(text = mailData.username, fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.subject, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            Text(text = mailData.body, fontSize = 12.sp)
        }
        Column() {
            Text(text = mailData.timestamp)
            IconButton(onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(50.dp)
                    .padding(top = 16.dp)) {
                Icon(imageVector = Icons.Outlined.StarOutline,
                    contentDescription = "Starred")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailItemPreview(){
    MailItem(mailData = MailData(
        mailId = 4,
        username = "Allano",
        subject = "Jetpack Compose",
        body = "How is your journey of learning Jetpack Compose coming along?",
        timestamp = "20:38"
    ))
}