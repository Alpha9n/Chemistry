package pro.freeserver.alphakun.plugin.chemistry.substances

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object Sodium {

    fun waterReaction(item: ItemStack): ItemStack {
        return SodiumHydroxide.getSodiumHydroxide(item.amount)
    }

    fun isSodium(item: ItemStack): Boolean {
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore()!!.size >= 0 && item.lore()?.get(0)?.equals(Component.text("§f§l原子番号11の元素")) == true)
    }

    fun getSodium(amount: Int): ItemStack {
        return ItemStackAPI.getItemStack(Material.IRON_INGOT, amount,"§9§o§lナトリウム§6[Na]", listOf("§f§l原子番号11の元素", "§6§o水と激しく反応する"))
    }
}