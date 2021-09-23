package pro.freeserver.alphakun.plugin.chemistry

import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin

class Chemistry : JavaPlugin() {
    override fun onEnable() {
        plugin = this
    }

    override fun onDisable() {}

    companion object {
        val prefix = "§f[§aChemistry§f]§r "
        lateinit var plugin: Plugin
    }
}