package pro.freeserver.alphakun.plugin.chemistry.interfaces

import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType

interface Substance {
    fun getSubstanceType(): SubstanceType
    fun getSubstance(amount: Int): ItemStack
    fun isSubstance(item: ItemStack): Boolean
}