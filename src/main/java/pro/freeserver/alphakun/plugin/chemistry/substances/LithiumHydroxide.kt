package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.Color
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.interfaces.Substance

class LithiumHydroxide: Substance {
    override fun getSubstanceType(): SubstanceType {
        return SubstanceType.LITHIUM_HYDROXIDE
    }

    override fun getSubstance(amount: Int): ItemStack {
        return ItemStackAPI.getPotionItem(
            Color.BLUE, PotionEffect(PotionEffectType.POISON, 60, 10, false, false, true),
            PotionType.WATER, amount, "§9§o§l水酸化リチウム水溶液§6§o§l[NaOH]", listOf("§f§lリチウムの水酸化物", "§6§o強アルカリ性を示し腐食性を持つ"),
            0, true
        )
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§lリチウムの水酸化物")
    }
}