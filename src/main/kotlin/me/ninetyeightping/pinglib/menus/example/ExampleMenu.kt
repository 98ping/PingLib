package me.ninetyeightping.pinglib.menus.example

import me.ninetyeightping.pinglib.menus.Button
import me.ninetyeightping.pinglib.menus.Menu
import me.ninetyeightping.pinglib.menus.pagination.PaginatedMenu
import org.bukkit.entity.Player

class ExampleMenu(player: Player) :
    PaginatedMenu(18, player) {



    override fun getPagesButtons(player: Player): MutableMap<Int, Button> {
        val buttons = hashMapOf<Int, Button>()

        buttons[10] = ExampleButton()
        buttons[9] = ExampleButton()
        buttons[6] = ExampleButton()

        return buttons
    }

    override fun getTitle(player: Player): String {
       return "potato menu"
    }
}