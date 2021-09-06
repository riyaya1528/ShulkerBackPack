package riyaya1528.spigot.shulkerbackpack;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import riyaya1528.spigot.shulkerbackpack.Events.PlayerRightClickShulkerEvent;
import riyaya1528.spigot.shulkerbackpack.Events.ShulkerClickInventory;
import riyaya1528.spigot.shulkerbackpack.Events.addShulkerEvent;
import riyaya1528.spigot.shulkerbackpack.Events.itemMoveEvent;
import riyaya1528.spigot.shulkerbackpack.Utils.addRecipes;

public final class ShulkerBackPack extends JavaPlugin {
    public static ShulkerBackPack instance;
    @Override
    public void onEnable() {
        instance = this;
        if(!RegisterEvents(this)) {
            getLogger().warning("イベントの登録に失敗しました");
            this.getPluginLoader().disablePlugin(this);
        }else {
            getLogger().info("イベントの登録に成功しました");
        }
        if(!addRecipes.addShulkerRecipe(this)) {
            getLogger().warning("レシピ登録に失敗しました");
            this.getPluginLoader().disablePlugin(this);
        }else {
            getLogger().info("レシピの登録に成功しました");
        }
        getLogger().info("プラグインが有効になりました");
    }

    @Override
    public void onDisable() {
        getLogger().info("プラグインが無効になりました");
    }

    public boolean RegisterEvents(Plugin plugin) {
        getServer().getPluginManager().registerEvents(new PlayerRightClickShulkerEvent(),plugin);
        getServer().getPluginManager().registerEvents(new addShulkerEvent(),plugin);
        getServer().getPluginManager().registerEvents(new itemMoveEvent(),plugin);
        getServer().getPluginManager().registerEvents(new ShulkerClickInventory(),plugin);
        return true;
    }
}
