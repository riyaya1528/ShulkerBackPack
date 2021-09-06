package riyaya1528.spigot.shulkerbackpack.Events;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

public class ShulkerClickInventory implements Listener {
    @EventHandler
    public void onClickShulker(InventoryClickEvent e) {
        if(e.getCurrentItem() == null) {
            return;
        }
        if(!e.getWhoClicked().getInventory().getItemInMainHand().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if(e.getWhoClicked().getInventory().getItemInMainHand().getItemMeta().getLore() == null) {
            return;
        }
        if(!e.getView().getType().equals(InventoryType.SHULKER_BOX)) {
            return;
        }
        if(!e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lここは編集不可能です")) {
            return;
        }
        e.setCancelled(true);
        e.getWhoClicked().sendMessage("§c§lそこでのバックパックの移動は禁止されています");
        ((Player)e.getWhoClicked()).playSound(e.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_PLACE,1,1);
    }
}
