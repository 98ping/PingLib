package me.ninetyeightping.pinglib.menus

import org.bukkit.Bukkit
import org.bukkit.entity.Player

abstract class Menu(
    private val size: Int,
    private val player: Player
) {

    abstract fun getButtons(player: Player) : MutableMap<Int, Button>
    abstract fun getTitle(player: Player) : String

    fun getAllButtons() : MutableMap<Int, Button> {
        return getButtons(player)
    }


    fun openMenu() {
        val inventory = Bukkit.createInventory(null, size, getTitle(player))

        MenuController.addToMenuMap(player, this)

        for (entry in getAllButtons()) {
            inventory.setItem(entry.key, entry.value.constructItemStack(player))
        }

        player.openInventory(inventory)

    }





}