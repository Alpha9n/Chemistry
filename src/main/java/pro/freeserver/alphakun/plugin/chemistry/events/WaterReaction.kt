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
import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.substances.Sodium

class WaterReaction : Listener {

    @EventHandler
    fun entityInsideBlock(e: EntityInsideBlockEvent) {
        if (e.entityType == EntityType.DROPPED_ITEM) {
            TODO("この下が動作しないので要変更")
            val item = e.entity as Item
            val loc = item.location
            if (e.block.type == Material.WATER) {
                if (itemDetection(item.itemStack, loc) != null){
                    item.remove()
                    loc.world.dropItem(loc,itemDetection(item.itemStack, loc)!!)
                }
            } else if (e.block.type == Material.CAULDRON && e.block is Levelled) {
                val cauldronData = e.block as Levelled
                if (cauldronData.level > 0) {
                    if (itemDetection(item.itemStack, loc) != null){
                        item.remove()
                        loc.world.dropItem(loc,itemDetection(item.itemStack, loc)!!)
                    }
                }
            }
        }
    }

    fun itemDetection(item: ItemStack, loc: Location): ItemStack? {
        if (Sodium.isSubstance(item)) {
            return Sodium.waterReaction(item,loc)
        }
        return null
    }
}