package pro.freeserver.alphakun.plugin.chemistry.api

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionType

object ItemStackAPI {
    fun getItemStack(
        material: Material?,
        amount: Int = 1,
        displayName: String?,
        lore: List<String?>?,
        customModelData: Int = 0
    ): ItemStack {
        val itemStack = ItemStack(material!!, amount)
        val itemMeta = itemStack.itemMeta
        itemMeta.setDisplayName(displayName)
        itemMeta.lore = lore
        itemMeta.setCustomModelData(customModelData)
        itemStack.itemMeta = itemMeta
        return itemStack
    }

    fun getPotionItem(
        color: Color = Color.AQUA,
        potionEffect: PotionEffect,
        potionType: PotionType = PotionType.WATER,
        amount: Int = 1,
        displayName: String,
        lore: List<String>,
        customModelData: Int = 0
    ) {
        val itemStack = ItemStack(Material.POTION, amount)
        val potionMeta = itemStack as PotionMeta
        potionMeta.basePotionData = PotionData(potionType)
        potionMeta.addCustomEffect(potionEffect, true)
        potionMeta.color = color
        potionMeta.setDisplayName(displayName)
        potionMeta.lore = lore
        potionMeta.setCustomModelData(customModelData)
    }
}