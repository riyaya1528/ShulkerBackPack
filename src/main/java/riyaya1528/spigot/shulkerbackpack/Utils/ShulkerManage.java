package riyaya1528.spigot.shulkerbackpack.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class ShulkerManage {
    public static void OpenShulker(Player player, ItemStack itemStack) {
        BlockStateMeta im = (BlockStateMeta) itemStack.getItemMeta();
        ShulkerBox shulker = (ShulkerBox) im.getBlockState();
        ItemStack[] shulkerContests = shulker.getInventory().getContents();
        Inventory inv = Bukkit.createInventory(null, InventoryType.SHULKER_BOX,itemStack.getItemMeta().getDisplayName());
        inv.setContents(shulkerContests);

        player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER,1,0);
        ItemStack none = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName("§c§lここは編集不可能です");
        none.setItemMeta(noneMeta);
        int n = 18;
        while(n <= 26) {
            inv.setItem(n,none);
            n = n + 1;
        }
        player.openInventory(inv);
    }
    public static void CloseShulker(Player player, ItemStack ItemStack,Inventory inventory) {
        String getitemname = ItemStack.getItemMeta().getDisplayName();
        ItemStack itemStack = new ItemStack(ItemStack);

        BlockStateMeta bsm = (BlockStateMeta) itemStack.getItemMeta();
        ShulkerBox box = (ShulkerBox) bsm.getBlockState();
        box.getInventory().setContents(inventory.getContents());
        bsm.setDisplayName(ItemStack.getItemMeta().getDisplayName());
        bsm.setLore(ItemStack.getItemMeta().getLore());
        bsm.setBlockState(box);
        box.update();
        itemStack.setItemMeta(bsm);
        player.getInventory().setItem(player.getInventory().getHeldItemSlot(), itemStack);

        player.playSound(player.getLocation(), Sound.ITEM_ARMOR_EQUIP_LEATHER,1,1);
    }
}
