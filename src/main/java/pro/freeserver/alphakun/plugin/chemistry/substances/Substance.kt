package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.inventory.ItemStack

interface Substance {
    fun getSubstance(amount: Int): ItemStack
    fun isSubstance(item: ItemStack): Boolean
}