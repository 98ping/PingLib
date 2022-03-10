package me.ninetyeightping.pinglib.scoreboard

import org.bukkit.entity.Player

abstract class PingScoreboard {

    abstract fun getTitle() : String
    abstract fun getLines(player: Player) : MutableList<String>

    var sbentries = arrayListOf<PingScoreboardEntry>()

    fun sendScoreboard(player: Player) {

    }
}