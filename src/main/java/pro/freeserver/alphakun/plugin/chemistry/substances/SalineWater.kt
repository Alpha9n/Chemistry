package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.Color
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.interfaces.Substance

class SalineWater: Substance {
    override fun getSubstanceType(): SubstanceType {
        return SubstanceType.SALINE_WATER
    }

    override fun getSubstance(amount: Int): ItemStack {
        return (ItemStackAPI.getPotionItem(
            Color.BLUE, PotionEffect(PotionEffectType.SPEED, 0,0,false,false,false),
            PotionType.WATER,amount,"§9§o§l食塩水§6§o§l[NaCl]", listOf("§f§l水に食塩を溶かした溶液", "§6§o塩水または、生理食塩水とも呼ばれる"),0,true))
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§l水に食塩を溶かした溶液")
    }

}