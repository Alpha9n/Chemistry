package pro.freeserver.alphakun.plugin.chemistry.interfaces

import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType

interface Substance {
    fun getSubstanceType(): SubstanceType

    fun getSubstance(amount: Int): ItemStack {
        TODO("この物質のアイテムについて記述")
    }

    fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "lore1行目を記入")
    }
}