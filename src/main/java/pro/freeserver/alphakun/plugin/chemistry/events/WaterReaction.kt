package pro.freeserver.alphakun.plugin.chemistry.events

import io.papermc.paper.event.entity.EntityInsideBlockEvent
import org.bukkit.Material
import org.bukkit.block.data.Levelled
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack

class WaterReaction : Listener {

    @EventHandler
    fun entityInsideBlock(e: EntityInsideBlockEvent) {
        if (e.entityType == EntityType.DROPPED_ITEM && e.entity is Item) {
            val item = e.entity as Item
            if (e.block.type == Material.WATER) {
                itemDetection(item.itemStack)
            } else if (e.block.type == Material.CAULDRON && e.block is Levelled) {
                val cauldronData = e.block as Levelled
                if (cauldronData.level > 0) {
                    itemDetection(item.itemStack)
                }
            }
        }
    }

    fun itemDetection(item: ItemStack) {

    }
}