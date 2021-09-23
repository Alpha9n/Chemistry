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
                sender.sendMessage("--------[§5NFUID§f/§b" + Chemistry.plugin.description.version + "§f]--------")
                sender.sendMessage("§aAuthor§f: あるふぁ(@Alphakun_)")
                sender.sendMessage("§bCommands§f:")
                sender.sendMessage("§d/chemistry§f: このヘルプを表示")
                sender.sendMessage("§d/chemistry list§f: 物質のリストを表示します")
                sender.sendMessage("§d/chemistry <MaterialName> [Player]§f: MaterialNameで指定した物質を与えます")
            } else {
                if (args[0].equals("list", true)) {
                    for (substance in SubstanceType.values()) {
                        TODO("Enumから各要素の日本語名とフレンドリーネームを取得後、チャット欄リスト表示")
                    }
                }
                return true
            }
        }
        return false
    }
}