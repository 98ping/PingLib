package me.ninetyeightping.pinglib.cooldown

import org.bukkit.Bukkit
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

object CooldownRepeatingTask {

    val service: ScheduledExecutorService = Executors.newSingleThreadScheduledExecutor()

    fun startCooldownChecking() {
        service.scheduleAtFixedRate( {
            for (entry in CooldownBuilder.table.cellSet())
            {
                val cd = entry.rowKey

                val timeLeft = entry.value

                val uuid = entry.columnKey

                if (timeLeft - System.currentTimeMillis() <= 0)
                {
                    val player = Bukkit.getPlayer(uuid)

                    if (player != null) {
                        cd.expire.invoke(player)
                    }
                }


            }
        }, 0L, 20L, TimeUnit.MILLISECONDS)
    }
}