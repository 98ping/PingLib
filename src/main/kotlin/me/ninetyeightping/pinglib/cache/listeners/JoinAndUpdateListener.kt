package me.ninetyeightping.pinglib.cache.listeners

import me.ninetyeightping.pinglib.PingLib
import me.ninetyeightping.pinglib.cache.types.UUIDCache
import me.ninetyeightping.pinglib.menus.example.ExampleMenu
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerPreLoginEvent
import org.bukkit.event.player.PlayerJoinEvent

class JoinAndUpdateListener : Listener {

    @EventHandler
    fun joinAndUpdateUUIDs(event: PlayerJoinEvent) {
        UUIDCache.addPlayerToUUIDCache(event.player)
    }
}