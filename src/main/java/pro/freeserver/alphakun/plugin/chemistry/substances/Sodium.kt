package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object Sodium {

    fun waterReaction() : ItemStack? {
        ItemStackAPI.getPotionItem(Color.AQUA, PotionEffect())
    }
}