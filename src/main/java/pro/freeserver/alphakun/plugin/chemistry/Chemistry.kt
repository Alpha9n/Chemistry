package pro.freeserver.alphakun.plugin.chemistry

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import pro.freeserver.alphakun.plugin.chemistry.commands.ProvideSubstance
import pro.freeserver.alphakun.plugin.chemistry.events.WaterReaction

class Chemistry : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        loadCommands()
    }

    override fun onDisable() {}

    fun loadCommands() {
        getCommand("givematerial")!!.setExecutor(ProvideSubstance())
    }

    companion object {
        val prefix = "§f[§aChemistry§f]§r "
        lateinit var plugin: Plugin
    }
}