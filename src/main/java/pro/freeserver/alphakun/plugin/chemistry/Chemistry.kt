package pro.freeserver.alphakun.plugin.chemistry

import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import pro.freeserver.alphakun.plugin.chemistry.commands.ProvideSubstance
import pro.freeserver.alphakun.plugin.chemistry.events.WaterReaction

class Chemistry : JavaPlugin() {
    override fun onEnable() {
        plugin = this
        loadCommands()
        loadEvents()
    }

    override fun onDisable() {

    }

    fun loadCommands() {
        getCommand("chemistry")!!.setExecutor(ProvideSubstance())
    }

    fun loadEvents() {
        server.pluginManager.registerEvents(WaterReaction(),plugin)
    }

    companion object {
        val prefix = "§f[§aChemistry§f]§r "
        lateinit var plugin: Plugin
    }
}