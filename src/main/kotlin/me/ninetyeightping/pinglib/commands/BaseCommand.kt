package me.ninetyeightping.pinglib.commands

import me.ninetyeightping.pinglib.util.CC
import org.bukkit.command.CommandSender


abstract class BaseCommand {

    abstract fun execute(sender: CommandSender?, command: String?, args: Array<String?>?)
    val info: Command get() = javaClass.getDeclaredAnnotation(Command::class.java)

    fun getBaseUsage() : String {
        return CC.translate("&6Usage: &e/" + info.name)
    }

    fun argsArePresent(args: Array<String?>?) : Boolean {
        return args!!.isNotEmpty()
    }

    fun constructStringBuilder(args: Array<String?>?, index: Int) : java.lang.StringBuilder {
        val builder = StringBuilder()

        for (i in index until args!!.size) {
            builder.append(args[i]).append(" ")
        }

        return builder
    }
}
