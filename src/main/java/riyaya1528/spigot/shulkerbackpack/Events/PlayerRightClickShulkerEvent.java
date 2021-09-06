package riyaya1528.spigot.shulkerbackpack.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import riyaya1528.spigot.shulkerbackpack.Utils.ShulkerManage;

public class PlayerRightClickShulkerEvent implements Listener {
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (!e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SHULKER_BOX)) {
                return;
            }
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) {
                return;
            }
            ShulkerManage.OpenShulker(e.getPlayer(), e.getPlayer().getInventory().getItemInMainHand());
        }
    }
    @EventHandler
    public void onCloseChulker(InventoryCloseEvent e) {
        if (!e.getPlayer().getInventory().getItemInMainHand().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) {
            return;
        }
        ShulkerManage.CloseShulker((Player) e.getPlayer(),e.getPlayer().getInventory().getItemInMainHand(),e.getInventory());
    }
}
