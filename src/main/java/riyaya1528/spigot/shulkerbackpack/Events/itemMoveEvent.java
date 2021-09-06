package riyaya1528.spigot.shulkerbackpack.Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;

public class itemMoveEvent implements Listener {
    @EventHandler
    public void onItemMove(InventoryMoveItemEvent e) {
        if(!e.getItem().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if(e.getItem().getItemMeta().getLore() == null) {
            return;
        }
        e.setCancelled(true);
    }
    @EventHandler
    public void onItemPutDispenser(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) {
            return;
        }
        if(!e.getCurrentItem().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if(e.getCurrentItem().getItemMeta().getLore() == null) {
            return;
        }
        if(!e.getView().getType().equals(InventoryType.DISPENSER)) {
            return;
        }
        e.setCancelled(true);
        e.getWhoClicked().sendMessage("§c§lそこでのバックパックの移動は禁止されています");
        ((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE,1,1);
    }
    @EventHandler
    public void onItemShulker(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) {
            return;
        }
        if(!e.getCurrentItem().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if(e.getCurrentItem().getItemMeta().getLore() == null) {
            return;
        }
        if(!e.getView().getType().equals(InventoryType.SHULKER_BOX)) {
            return;
        }
        e.setCancelled(true);
        e.getWhoClicked().sendMessage("§c§lそこでのバックパックの移動は禁止されています");
        ((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE,1,1);
    }
}
