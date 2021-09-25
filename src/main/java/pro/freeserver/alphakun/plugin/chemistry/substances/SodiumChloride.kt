package pro.freeserver.alphakun.plugin.chemistry.substances

import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.api.ItemStackAPI

object SodiumChloride: Substance{

    override fun getSubstance(amount: Int): ItemStack {
        return (ItemStackAPI.getItemStack(Material.SUGAR, amount, "§9§o§l塩化ナトリウム§6§o§l[NaCl]", listOf("§f§lナトリウムの塩化物", "§6§o単に塩（しお）、あるいは食塩と呼ばれる")))
    }

    override fun isSubstance(item: ItemStack): Boolean {
        return (item.hasItemMeta() && item.itemMeta.hasLore() && item.itemMeta.lore()!!.size >= 0 && item.lore()?.get(0)
            ?.equals(Component.text("§f§lナトリウムの塩化物")) == true)
    }
}