package me.ninetyeightping.pinglib.visibility

import org.bukkit.entity.Player
class VisibilityManager {

    lateinit var startvisibility: (Player) -> Unit
    lateinit var changevisibility: (Player) -> Unit


    fun onChangeVisibility(predicate: (Player) -> Unit = {}): VisibilityManager
    {
        return this.apply {
            changevisibility = predicate
        }
    }

    fun onStartVisibility(predicate: (Player) -> Unit = {}): VisibilityManager
    {
        return this.apply {
           startvisibility = predicate
        }
    }


    fun processChangeVisibility(player: Player)
    {
        changevisibility.invoke(player)
    }

    fun processStartVisibility(player: Player)
    {
        startvisibility.invoke(player)
    }

}