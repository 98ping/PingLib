package me.ninetyeightping.pinglib.commands.default

import me.ninetyeightping.pinglib.commands.BaseCommand
import me.ninetyeightping.pinglib.commands.Command
import me.ninetyeightping.pinglib.util.CC
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import java.lang.StringBuilder

@Command(name = "broadcast", aliases = ["bc"], permission = "pinglib.broadcast")
class BroadcastCommand : BaseCommand() {

    override fun execute(sender: CommandSender?, command: String?, args: Array<String?>?) {

        if (!argsArePresent(args)) {
            sender!!.sendMessage(CC.translate(getBaseUsage() + " <message...>"))
            return
        }

        val builder = constructStringBuilder(args, 0)


        Bukkit.broadcastMessage(CC.translate(builder.toString()))
    }
}