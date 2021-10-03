package pro.freeserver.alphakun.plugin.chemistry.events

import io.papermc.paper.event.entity.EntityMoveEvent
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.data.Levelled
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import pro.freeserver.alphakun.plugin.chemistry.Chemistry.Companion.plugin
import pro.freeserver.alphakun.plugin.chemistry.interfaces.HydrolysisSubstance
import pro.freeserver.alphakun.plugin.chemistry.utils.SubstanceUtil

class WaterReaction : Listener {

    @EventHandler
    fun EntityMove(e: EntityMoveEvent) {
        Bukkit.broadcastMessage("EntityMoveEvent")
        val dropItemList: MutableList<Item> = mutableListOf()
        val toleranceTime: Int = 20 * 5
        if (e.entity is Item) {
            Bukkit.broadcastMessage("EntityMoveEvent: entity is Item")
            dropItemList.add(e.entity as Item)
            object: BukkitRunnable() {
                override fun run() {
                    for (dropItem in dropItemList) {
                        if (dropItem.ticksLived >= toleranceTime) {
                            dropItemList.remove(dropItem)
                        } else {
                            blockWaterDetection(e.entity)
                        }
                    }
                }
            }.runTaskTimer(plugin,1,1)
        }
    }

    fun blockWaterDetection(entity: Entity) {
        val loc = entity.location
        val block = loc.world.getBlockAt(loc)
        if (entity is Item) {
            var item = entity.itemStack
            if (block.type.equals(Material.WATER)) {
                item = itemDetection(item, loc)
            } else if (block.type == Material.CAULDRON) {
                val cauldronData = block.blockData as Levelled
                if (cauldronData.level > 0) {
                    item = itemDetection(item, loc)
                    cauldronData.level-=1
                    block.blockData = cauldronData
                }
            }
        }
    }

    fun itemDetection(item: ItemStack, loc: Location): ItemStack {
        val substance = SubstanceUtil.getSubstanceClass(item)
        if (substance != null && substance is HydrolysisSubstance) {
            return substance.waterReaction(item,loc)
        }
        return item
    }
}