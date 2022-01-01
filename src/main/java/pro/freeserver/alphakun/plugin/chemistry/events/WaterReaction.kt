package pro.freeserver.alphakun.plugin.chemistry.events

import io.papermc.paper.event.entity.EntityInsideBlockEvent
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.block.data.Levelled
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.scheduler.BukkitRunnable
import pro.freeserver.alphakun.plugin.chemistry.Chemistry.Companion.plugin
import pro.freeserver.alphakun.plugin.chemistry.interfaces.HydrolysisSubstance
import pro.freeserver.alphakun.plugin.chemistry.interfaces.Substance
import pro.freeserver.alphakun.plugin.chemistry.substances.HydrochloricAcid
import pro.freeserver.alphakun.plugin.chemistry.substances.Sodium
import pro.freeserver.alphakun.plugin.chemistry.substances.SodiumChloride
import pro.freeserver.alphakun.plugin.chemistry.utils.SubstanceUtil

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
        var runCount = 0
        object: BukkitRunnable() {
            override fun run() {
                if (runCount < 100) runCount++ else cancel()
                blockWaterDetection(e.itemDrop)
            }
        }.runTaskTimer(plugin,1,1)
    }

    fun blockWaterDetection(entity: Entity) {
        val loc = entity.location
        if (entity is Item && loc.world.getBlockAt(loc).type.equals(Material.WATER)) {
            var item = entity.itemStack
            item = itemDetection(item, loc)
            entity.itemStack = item
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