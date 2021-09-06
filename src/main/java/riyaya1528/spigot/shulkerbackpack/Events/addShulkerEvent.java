package riyaya1528.spigot.shulkerbackpack.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class addShulkerEvent implements Listener {
    @EventHandler
    public void onaddShulker(BlockPlaceEvent e) {
        if(!e.getItemInHand().getType().equals(Material.SHULKER_BOX)) {
            return;
        }
        if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getLore() == null) {
            return;
        }

        e.setCancelled(true);
    }
}
