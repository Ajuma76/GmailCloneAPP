package com.example.gmailclone.model

import java.sql.Timestamp
import javax.security.auth.Subject

data class MailData(
    val mailId:Int,
    val username:String,
    val subject: String,
    val body: String,
    val timestamp: String = ""
)
