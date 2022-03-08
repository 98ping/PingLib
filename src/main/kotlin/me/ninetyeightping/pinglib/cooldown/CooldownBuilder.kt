package me.ninetyeightping.pinglib.cooldown

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import org.bukkit.entity.Player
import java.time.Duration
import java.util.*

object CooldownBuilder {

    lateinit var expire : (Player) -> Unit

    var table: HashBasedTable<CooldownBuilder, UUID, Long> = HashBasedTable.create()

    lateinit var cooldownName: String

    fun giveColdown(player: Player, duration: Long) {
        table.put(this, player.uniqueId, System.currentTimeMillis() + duration)
    }

    fun setCooldownName(name: String) : CooldownBuilder {
        return this.apply {
            cooldownName = name
        }
    }

    fun onExpire(predicate: (Player) -> Unit = {}) : CooldownBuilder {
        return this.apply {
            expire = predicate
        }
    }


}