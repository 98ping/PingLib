package me.ninetyeightping.pinglib.commands

import me.ninetyeightping.pinglib.PingLib
import me.ninetyeightping.pinglib.commands.default.BroadcastCommand
import me.ninetyeightping.pinglib.commands.default.OpenPotatoMenuCommand
import me.ninetyeightping.pinglib.commands.default.VisibilityChangeCommand
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.SimpleCommandMap
import org.bukkit.plugin.SimplePluginManager
import java.util.*
import java.util.function.Consumer
import java.util.stream.Collectors
import kotlin.collections.HashMap


class CommandHandler {
    private val registerCommands: MutableList<BaseCommand> = ArrayList()
    lateinit var BUKKIT_COMMAND_MAP: SimpleCommandMap

    fun loadHandler(): CommandHandler {
        loadSimpleCommandMap()
        reloadHandler()

        registerCommand(OpenPotatoMenuCommand())
        registerCommand(BroadcastCommand())
        registerCommand(VisibilityChangeCommand())
        return this
    }



    fun loadSimpleCommandMap() {
        val pluginManager = PingLib.instance.server.pluginManager
        val map = SimplePluginManager::class.java.getDeclaredField("commandMap")

        map.isAccessible = true

        BUKKIT_COMMAND_MAP = map.get(pluginManager) as SimpleCommandMap
    }

    fun reloadHandler() {
        registerCommands.stream().filter { command: BaseCommand ->
            !BUKKIT_COMMAND_MAP.commands.stream().map { obj: Command -> obj.name }
                .collect(Collectors.toList())
                .contains(command.info.name)
        }.forEach { command: BaseCommand? ->
            BUKKIT_COMMAND_MAP.register(
                "", CommandProcessor(
                    command!!
                )
            )
        }
    }

    fun registerCommand(command: BaseCommand): BaseCommand {
        registerCommands.add(command)
        reloadHandler()
        return command
    }

}
