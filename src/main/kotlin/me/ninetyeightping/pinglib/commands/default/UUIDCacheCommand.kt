package me.ninetyeightping.pinglib.commands.default

import me.ninetyeightping.pinglib.cache.types.UUIDCache
import me.ninetyeightping.pinglib.commands.BaseCommand
import me.ninetyeightping.pinglib.commands.Command
import me.ninetyeightping.pinglib.util.CC
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import java.util.*

@Command(name = "uuidcache", permission = "pinglib.uuidcache")
class UUIDCacheCommand : BaseCommand() {


    override fun execute(sender: CommandSender?, command: String?, args: Array<String?>?) {
        if (!argsArePresent(args)) {
            sender!!.sendMessage(CC.translate(getBaseUsage() + " <target>"))
            return
        }

        val string = args?.get(0)

        val uuid = UUIDCache.BbyA(string!!)

        if (uuid == null) {
            sender!!.sendMessage(CC.translate("&cPlayer was not in UUID cache."))
            return
        }

        sender!!.sendMessage(CC.translate("&aName : $string |  UUID : $uuid"))

    }
}