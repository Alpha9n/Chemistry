package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.Color
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object HydrochloricAcid: Substance {
    override fun getSubstance(amount: Int): ItemStack {
        return ItemStackAPI.getPotionItem(
            Color.BLUE, PotionEffect(PotionEffectType.POISON, 60, 10, false, false, true),
            PotionType.WATER, amount, "§9§o§l塩酸§6§o§l[HCl]", listOf("§f§l塩化水素の水溶液", "§6§o代表的な酸のひとつで、強い酸性を示す"),
            0, true
        )
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§lナトリウムの塩化物")
    }
}