package me.ninetyeightping.pinglib.commands.default

import me.ninetyeightping.pinglib.PingLib
import me.ninetyeightping.pinglib.commands.BaseCommand
import me.ninetyeightping.pinglib.commands.Command
import me.ninetyeightping.pinglib.commands.CommandSenderType
import me.ninetyeightping.pinglib.util.CC
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

@Command(name = "vis", permission = "pinglib.vis", senderType = CommandSenderType.PLAYER)
class VisibilityChangeCommand : BaseCommand() {

    override fun execute(sender: CommandSender?, command: String?, args: Array<String?>?) {
        if (!argsArePresent(args)) {
            sender!!.sendMessage(CC.translate(getBaseUsage() + " <visibility>"))
            return
        }

        val visibility = args?.get(0)

        when (visibility) {
            "on" -> {
                PingLib.instance.defaultVisibilityHandler.processStartVisibility(sender as Player)
                sender.sendMessage(CC.translate("&aTurned visibility debug on"))
            }

            "off" -> {
                PingLib.instance.defaultVisibilityHandler.processChangeVisibility(sender as Player)
                sender.sendMessage(CC.translate("&cTurned visibility debug off"))
            }
        }
    }
}