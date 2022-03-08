package me.ninetyeightping.pinglib.commands.default

import me.ninetyeightping.pinglib.PingLib
import me.ninetyeightping.pinglib.commands.BaseCommand
import me.ninetyeightping.pinglib.commands.Command
import me.ninetyeightping.pinglib.cooldown.CooldownBuilder
import me.ninetyeightping.pinglib.util.CC
import org.bukkit.Bukkit
import org.bukkit.command.CommandSender
import java.util.*
import java.util.concurrent.TimeUnit

@Command(name = "givecooldown", permission = "pinglib.cooldown")
class GiveCooldownCommand : BaseCommand() {

    override fun execute(sender: CommandSender?, command: String?, args: Array<String?>?) {
        if (!argsArePresent(args)) {
            sender!!.sendMessage(getBaseUsage() + " <target>")
            return
        }

        val player = Bukkit.getPlayer(UUID.fromString(args?.get(0)))

        if (player == null) {
            sender!!.sendMessage(CC.translate("&cPlayer not found"))
            return
        }

        PingLib.instance.defaultCooldownBuilder.giveColdown(player, TimeUnit.SECONDS.toMillis(5))
        sender!!.sendMessage(CC.translate("&aGave " + player.name + " &aa cooldown"))
    }
}