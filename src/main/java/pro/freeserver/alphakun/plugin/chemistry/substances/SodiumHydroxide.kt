package pro.freeserver.alphakun.plugin.chemistry.substances

import net.kyori.adventure.text.Component
import org.bukkit.Color
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object SodiumHydroxide: Substance {

    override fun getSubstance(amount: Int): ItemStack {
        return ItemStackAPI.getPotionItem(
            Color.BLUE, PotionEffect(PotionEffectType.POISON, 30, 10, false, false, true),
            PotionType.WATER, amount, "§9§o§l水酸化ナトリウム水溶液§6§o§l[NaOH]", listOf("§f§lナトリウムの水酸化物", "§6§o強塩基として大規模に用いられている"),
            0, true
        )
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§lナトリウムの水酸化物")
    }
}