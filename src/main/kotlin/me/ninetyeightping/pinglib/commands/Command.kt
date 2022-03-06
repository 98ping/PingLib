package me.ninetyeightping.pinglib.commands

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy


@Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
@Retention(RetentionPolicy.RUNTIME)
annotation class Command(
    val name: String,
    val aliases: Array<String> = [],
    val permission: String = "",
    val description: String = "",
    val usage: String = "",
    val senderType: CommandSenderType = CommandSenderType.ALL,
    val async: Boolean = false
)
