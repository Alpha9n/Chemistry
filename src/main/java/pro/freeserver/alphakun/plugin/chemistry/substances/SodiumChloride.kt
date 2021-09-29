package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.*
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.interfaces.HydrolysisSubstance
import pro.freeserver.alphakun.plugin.chemistry.interfaces.Substance
import pro.freeserver.alphakun.plugin.chemistry.utils.SubstanceUtil

class SodiumChloride: HydrolysisSubstance {

    override fun waterReaction(item: ItemStack, loc: Location): ItemStack {
        return (SubstanceUtil.getSubstanceClass(SubstanceType.SALINE_WATER)!!.getSubstance(item.amount))
    }

    override fun getSubstanceType(): SubstanceType {
        return SubstanceType.SODIUM_CHLORIDE
    }

    override fun getSubstance(amount: Int): ItemStack {
        return (ItemStackAPI.getItemStack(Material.SUGAR, amount, "§9§o§l塩化ナトリウム§6§o§l[NaCl]", listOf("§f§lナトリウムの塩化物", "§6§o単に塩（しお）、あるいは食塩と呼ばれる")))
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§lナトリウムの塩化物")
    }
}