package com.think42labs.ktgmail.net

/**
 * @author Vazhavanthakumar
 * @since 26/12/19
 */
data class Response(
    val from: String,
    val id: Int,
    val isImportant: Boolean,
    val isRead: Boolean,
    val message: String,
    val picture: String,
    val subject: String,
    val timestamp: String
)