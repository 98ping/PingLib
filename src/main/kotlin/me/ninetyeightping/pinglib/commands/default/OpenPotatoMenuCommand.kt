package me.ninetyeightping.pinglib.commands.default

import me.ninetyeightping.pinglib.commands.BaseCommand
import me.ninetyeightping.pinglib.commands.Command
import me.ninetyeightping.pinglib.commands.CommandSenderType
import me.ninetyeightping.pinglib.menus.example.ExampleMenu
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Command(name = "potatomenu", permission = "pinglib.potatomenu", senderType = CommandSenderType.OP_PLAYER)
class OpenPotatoMenuCommand : BaseCommand() {

    override fun execute(sender: CommandSender?, command: String?, args: Array<String?>?) {
        ExampleMenu(sender as Player).updateMenu()
    }


}