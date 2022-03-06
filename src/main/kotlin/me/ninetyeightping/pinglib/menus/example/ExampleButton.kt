package me.ninetyeightping.pinglib.menus.example

import me.ninetyeightping.pinglib.menus.Button
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import java.util.*

class ExampleButton : Button() {
    override fun getMaterial(player: Player): Material {
        return Material.BAKED_POTATO
    }

    override fun getDescription(player: Player): MutableList<String>? {
        return Collections.singletonList("potato")
    }

    override fun getDisplayName(player: Player): String? {
        return ChatColor.translateAlternateColorCodes('&', "&6&l&n&opotato")
    }

    override fun onClick(player: Player, slot: Int, type: ClickType) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6Potato"))
    }
}