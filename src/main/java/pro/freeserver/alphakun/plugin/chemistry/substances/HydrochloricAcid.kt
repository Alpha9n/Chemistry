package pro.freeserver.alphakun.plugin.chemistry.substances

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.inventory.ItemStack
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.potion.PotionType
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.interfaces.HydrolysisSubstance

class HydrochloricAcid: HydrolysisSubstance {

    override fun waterReaction(item: ItemStack, loc: Location): ItemStack {
        loc.world.playSound(loc, Sound.BLOCK_LAVA_EXTINGUISH,0.2f,1f)
        loc.world.spawnParticle(Particle.CLOUD,loc,10,1.0,3.0,1.0,1.0)
        loc.getNearbyPlayers(1.0).forEach { it.damage(1.0) }
        return item
    }

    override fun getSubstanceType(): SubstanceType {
        return SubstanceType.HYDRO_CHLORIC_ACID
    }

    override fun getSubstance(amount: Int): ItemStack {
        return ItemStackAPI.getPotionItem(
            Color.BLUE, PotionEffect(PotionEffectType.POISON, 60, 10, false, false, true),
            PotionType.WATER, amount, "§9§o§l塩酸§6§o§l[HCl]", listOf("§f§l塩化水素の水溶液", "§6§o代表的な酸のひとつで、強い酸性を示す"),
            0, true
        )
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§l塩化水素の水溶液")
    }
}