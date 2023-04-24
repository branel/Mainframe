package com.branel.dashboard.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Menu implements CommandExecutor {
    private String invName = "Server Selector";
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(" Player only command");
            return true;
        }

        Player player = (Player)    sender;

        Inventory inv = Bukkit.createInventory(player, 9*3, invName);

        inv.setItem(11,getItem(new ItemStack(Material.BEDROCK), "&9Yes Haha I agree", "&a click to download more ram"));
        inv.setItem(13,getItem(new ItemStack(Material.BEACON), "&9Yes Haha I agree", "&a click to download more ram"));
        inv.setItem(15,getItem(new ItemStack(Material.BEDROCK), "&9Yes Haha I agree", "&a click to download more ram"));

        player.openInventory(inv);

    return true;
    }
    private ItemStack getItem(ItemStack item, String name, String ... lore){
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore)
        {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);

        item.setItemMeta(meta);
        return item;
    }
}
