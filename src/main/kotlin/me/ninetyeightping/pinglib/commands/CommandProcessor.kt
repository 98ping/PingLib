package me.ninetyeightping.pinglib.commands

import me.ninetyeightping.pinglib.util.CC.translate
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.ConsoleCommandSender
import org.bukkit.entity.Player
import java.util.*


class CommandProcessor(private val baseCommand: BaseCommand) :
    Command(baseCommand.javaClass.getDeclaredAnnotation(me.ninetyeightping.pinglib.commands.Command::class.java).name) {


    override fun execute(sender: CommandSender, label: String, args: Array<String>): Boolean {
        val command: me.ninetyeightping.pinglib.commands.Command = baseCommand.info
        when (command.senderType) {
            CommandSenderType.CONSOLE -> {
                run {
                    if (sender !is ConsoleCommandSender) {
                        sender.sendMessage(translate("&cThis command may only be performed by console."))
                        return true
                    }
                }
                run {
                    if (sender !is Player) {
                        sender.sendMessage(translate("&cThis command may only be performed by a player."))
                        return true
                    }
                }
                run {
                    if (!sender.isOp) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
                run {
                    if (sender !is Player || !sender.isOp()) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
                run {}
            }
            CommandSenderType.PLAYER -> {
                run {
                    if (sender !is Player) {
                        sender.sendMessage(translate("&cThis command may only be performed by a player."))
                        return true
                    }
                }
                run {
                    if (!sender.isOp) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
                run {
                    if (sender !is Player || !sender.isOp()) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
                run {}
            }
            CommandSenderType.OP -> {
                run {
                    if (!sender.isOp) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
                run {
                    if (sender !is Player || !sender.isOp()) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
            }
            CommandSenderType.OP_PLAYER -> {
                run {
                    if (sender !is Player || !sender.isOp()) {
                        sender.sendMessage(translate(permissionMessage))
                        return true
                    }
                }
            }
            else -> {
            }
        }
        baseCommand.execute(sender, label, args as Array<String?>)
        return true
    }

    init {
        val command: me.ninetyeightping.pinglib.commands.Command = baseCommand.info
        aliases = command.aliases.toList()
        description = command.description
        if (command.permission != "") {
            permission = command.permission
        }
        permissionMessage = translate("&cNo permission.")
        if (command.usage != null) usage = command.usage
    }
}
