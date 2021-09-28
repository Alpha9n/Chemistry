package pro.freeserver.alphakun.plugin.chemistry.substances

import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.Sound
import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object Sodium: Substance {

    fun waterReaction(item: ItemStack, loc: Location): ItemStack {
        loc.world.playSound(loc, Sound.ENTITY_GENERIC_EXPLODE,0.2f,1.2f)
        loc.world.spawnParticle(Particle.EXPLOSION_HUGE,loc,5,1.0,1.0,1.0)
        for (p in loc.getNearbyPlayers(3.0)) {
            p.damage(1.0)
        }
        return SodiumHydroxide.getSubstance(item.amount)
    }

    override fun getSubstance(amount: Int): ItemStack {
        return ItemStackAPI.getItemStack(Material.IRON_INGOT, amount,"§9§o§lナトリウム§6§o§l[Na]", listOf("§f§l原子番号11の元素", "§6§o水と激しく反応する"))
    }

    override fun isSubstance(item: ItemStack): Boolean {
        @Suppress("DEPRECATION")
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore?.get(0)!! == "§f§l原子番号11の元素")
    }
}