package pro.freeserver.alphakun.plugin.chemistry.api

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemFlag
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
        @Suppress("DEPRECATION")
        itemMeta.setDisplayName(displayName)
        @Suppress("DEPRECATION")
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
        customModelData: Int = 0,
        itemFlag: Boolean
    ): ItemStack {
        val itemStack = ItemStack(Material.POTION, amount)
        val potionMeta = itemStack.itemMeta as PotionMeta
        potionMeta.basePotionData = PotionData(potionType)
        potionMeta.addCustomEffect(potionEffect, true)
        potionMeta.color = color
        @Suppress("DEPRECATION")
        potionMeta.setDisplayName(displayName)
        @Suppress("DEPRECATION")
        potionMeta.lore = lore
        potionMeta.setCustomModelData(customModelData)
        if (itemFlag) potionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS)
        itemStack.itemMeta = potionMeta
        return itemStack
    }
}