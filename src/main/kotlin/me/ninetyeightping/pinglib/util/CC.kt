package me.ninetyeightping.pinglib.util

import org.bukkit.ChatColor

object CC {

    fun translate(string: String) : String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }
}