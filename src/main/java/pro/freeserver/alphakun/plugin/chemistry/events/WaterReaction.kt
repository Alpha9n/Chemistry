package pro.freeserver.alphakun.plugin.chemistry.events

import io.papermc.paper.event.entity.EntityInsideBlockEvent
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.data.Levelled
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.substances.Sodium
import pro.freeserver.alphakun.plugin.chemistry.substances.SodiumChloride
import kotlin.reflect.typeOf

class WaterReaction : Listener {

    @EventHandler
    fun entityInsideBlock(e: EntityInsideBlockEvent) {
        if (e.entityType == EntityType.DROPPED_ITEM) {
            val item = e.entity as Item
            val loc = item.location
            if (e.block.type == Material.CAULDRON) {
                val cauldronData = e.block.blockData as Levelled
                if (cauldronData.level > 0) {
                    item.itemStack = itemDetection(item.itemStack, loc)
                    cauldronData.level-=1
                    e.block.blockData = cauldronData
                }
            }
        }
    }

    @EventHandler
    fun playerDropItem(e: PlayerDropItemEvent) {
    }

    fun itemDetection(item: ItemStack, loc: Location): ItemStack {
        if (Sodium.isSubstance(item)) {
            return Sodium.waterReaction(item,loc)
        } else if (SodiumChloride.isSubstance(item)) {
            return SodiumChloride.waterReaction(item,loc)
        }
        return item
    }
}