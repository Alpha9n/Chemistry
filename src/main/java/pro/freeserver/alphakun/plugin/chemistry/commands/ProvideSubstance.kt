package pro.freeserver.alphakun.plugin.chemistry.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pro.freeserver.alphakun.plugin.chemistry.Chemistry
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType
import pro.freeserver.alphakun.plugin.chemistry.substances.Sodium
import pro.freeserver.alphakun.plugin.chemistry.substances.SodiumHydroxide

class ProvideSubstance: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player && command.name.equals("chemistry",true)) {
            if (args.isEmpty()) {
                sender.sendMessage("--------[§5Chemistry§f/§b" + Chemistry.plugin.description.version + "§f]--------")
                sender.sendMessage("§aAuthor§f: あるふぁ(@Alphakun_)")
                sender.sendMessage("§bCommands§f:")
                sender.sendMessage("§d/chemistry§f: このヘルプを表示")
                sender.sendMessage("§d/chemistry list§f: 物質のリストを表示します")
                sender.sendMessage("§d/chemistry <MaterialName> [Player]§f: MaterialNameで指定した物質を与えます")
            } else {
                if (args[0].equals("list", true)) {
                    sender.sendMessage("--------[§5Chemistry§f/§b" + Chemistry.plugin.description.version + "§f]--------")
                    sender.sendMessage("§bMaterials§f:\n§a名称 §f: §d日本語")
                    for (substance in SubstanceType.values()) {
                        sender.sendMessage("§a" + substance.friendlyName + " §f: §d" + substance.jpName)
                    }
                    sender.sendMessage("--------[§5Chemistry§f/§b" + Chemistry.plugin.description.version + "§f]--------")
                } else {
                    for (substance in SubstanceType.values()) {
                        if (substance.friendlyName == args[0]) {
                            giveSubstance(substance,sender)
                            return true
                        }
                    }
                }
                return true
            }
        }
        return false
    }

    fun giveSubstance(substance: SubstanceType, player: Player) {
        when (substance) {
            SubstanceType.SODIUM -> player.inventory.addItem(Sodium.getSubstance(1))
            SubstanceType.SODIUMHYDROXIDE -> player.inventory.addItem(SodiumHydroxide.getSubstance(1))
        }
    }
}