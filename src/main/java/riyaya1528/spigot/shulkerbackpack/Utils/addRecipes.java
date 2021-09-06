package riyaya1528.spigot.shulkerbackpack.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class addRecipes {
    public static boolean addShulkerRecipe(Plugin plugin) {
        ItemStack shulker = new ItemStack(Material.SHULKER_BOX);
        ItemMeta shulkerMeta = shulker.getItemMeta();
        shulkerMeta.setDisplayName("§a§lバックパック");
        ArrayList<String> shulkerLore = new ArrayList<>();
        shulkerLore.add("§2§lサイズ:18");
        shulkerMeta.setLore(shulkerLore);
        shulker.setItemMeta(shulkerMeta);

        NamespacedKey shulkerNamespaceKey = new NamespacedKey(plugin,"shulker_backpack");
        ShapedRecipe recipe = new ShapedRecipe(shulkerNamespaceKey, shulker);
        recipe.shape("SLS","LCL","SLS");
        recipe.setIngredient('L',Material.LEATHER);
        recipe.setIngredient('S',Material.STRING);
        recipe.setIngredient('C',Material.CHEST);

        Bukkit.addRecipe(recipe);
        return true;
    }
}
