package pro.freeserver.alphakun.plugin.chemistry.utils

import org.bukkit.inventory.ItemStack
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.interfaces.Substance
import pro.freeserver.alphakun.plugin.chemistry.substances.*

object SubstanceUtil {
    var substanceClassList: MutableList<Substance> = mutableListOf(
        Sodium(),
        SodiumChloride(),
        SodiumHydroxide(),
        HydrochloricAcid(),
        SalineWater(),
        Lithium(),
        LithiumHydroxide()
    )

    fun getSubstanceClass(subType: SubstanceType): Substance? {
        for (substanceClass in substanceClassList) {
            if (substanceClass.getSubstanceType() == subType) {
                return substanceClass
            }
        }
        return null
    }

    fun getSubstanceClass(item: ItemStack): Substance? {
        for (substanceClass in substanceClassList) {
            if (substanceClass.isSubstance(item)) {
                return substanceClass
            }
        }
        return null
    }
}