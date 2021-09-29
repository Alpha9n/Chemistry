package pro.freeserver.alphakun.plugin.chemistry.interfaces

import org.bukkit.Location
import org.bukkit.inventory.ItemStack

interface HydrolysisSubstance: Substance {
    fun waterReaction(item: ItemStack, loc: Location): ItemStack
}