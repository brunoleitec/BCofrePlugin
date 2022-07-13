package com.github.brunoleitec.bcofreplugin.commands;

import com.github.brunoleitec.bcofreplugin.utils.CofreUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;

import java.util.ArrayList;

public class OpenCommand  implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player){

            Player player = (Player) sender;

            if (args.length > 0){
                if (args[0].equalsIgnoreCase("open")){

                    ArrayList<ItemStack> vaultItems = CofreUtils.getItems(player);

                    Inventory vault = Bukkit.createInventory(player, 54, "Seu Cofre Pessoal");

                    vaultItems.stream()
                            .forEach(itemStack -> vault.addItem(itemStack));

                    player.openInventory(vault);

                }
            }

        }



        return true;
    }
}
