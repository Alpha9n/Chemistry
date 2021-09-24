package pro.freeserver.alphakun.plugin.chemistry.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import pro.freeserver.alphakun.plugin.chemistry.Chemistry
import pro.freeserver.alphakun.plugin.chemistry.enums.SubstanceType

class ProvideSubstance: CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player && command.name.equals("givematerial",true)) {
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
                    sender.sendMessage("§bMaterials§f:")
                    for (substance in SubstanceType.values()) {
                        sender.sendMessage("§a名称 §d" + substance.friendlyName + "§f:§a日本語 §d" + substance.jpName)
                    }
                    sender.sendMessage("--------[§5Chemistry§f/§b" + Chemistry.plugin.description.version + "§f]--------")
                } else {
                    for (substance in SubstanceType.values()) {
                        if (substance.friendlyName == args[0]) {
                            return true
                        }
                    }
                }
                return true
            }
        }
        return false
    }
}