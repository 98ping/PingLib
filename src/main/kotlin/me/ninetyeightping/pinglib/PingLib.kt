package me.ninetyeightping.pinglib

import me.ninetyeightping.pinglib.cache.listeners.JoinAndUpdateListener
import me.ninetyeightping.pinglib.commands.CommandHandler
import me.ninetyeightping.pinglib.menus.listener.MenuListener
import me.ninetyeightping.pinglib.visibility.VisibilityManager
import org.apache.commons.pool2.impl.GenericObjectPoolConfig
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import redis.clients.jedis.JedisPool
import java.util.logging.Level

class PingLib : JavaPlugin() {


    companion object {
        lateinit var instance: PingLib
    }

    lateinit var jedis: JedisPool
    lateinit var commandHandler: CommandHandler

    lateinit var defaultVisibilityHandler: VisibilityManager


    override fun onEnable() {
        instance = this

        jedis = JedisPool(GenericObjectPoolConfig(), "localhost", 6379, null, null)
        Bukkit.getLogger().log(Level.ALL, "Connected to redis")

        commandHandler = CommandHandler()
        commandHandler.loadHandler()

        defaultVisibilityHandler = VisibilityManager()
            .onChangeVisibility {
            for (player in Bukkit.getOnlinePlayers())
            {
                player.showPlayer(it)
            }
            println("Player has just been shown : " + it.name)
        }.onStartVisibility {
            for (player in Bukkit.getOnlinePlayers())
            {
                if (!player.isOp) {
                    player.hidePlayer(it)
                }
            }
           println("Player has just been hidden : " + it.name)
        }

        server.pluginManager.registerEvents(JoinAndUpdateListener(), this)
        server.pluginManager.registerEvents(MenuListener(), this)


    }

}