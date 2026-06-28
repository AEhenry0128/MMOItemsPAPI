package io.aehenry.mmoitempapi;

import io.lumine.mythic.lib.api.item.NBTItem;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import net.Indyuce.mmoitems.api.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PAPIExpansion extends PlaceholderExpansion {

    private final main plugin;

    public PAPIExpansion(main plugin) {
        this.plugin = plugin;
    }

    @Override
    public @NotNull String getIdentifier() {
        return "mmoitempapi";
    }

    @Override
    public @NotNull String getAuthor() {
        return "AEhenry";
    }

    @Override
    public @NotNull String getVersion() {
        return "release";
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {

        ItemStack handItem = player.getInventory().getItemInMainHand();
        if (handItem.getType().isAir()) return "NULL";
        NBTItem nbtItem = NBTItem.get(handItem);

        switch (params) {

            case "heldItem_isMMOITEM" -> {
                return String.valueOf(nbtItem.hasType());
            }
            case "heldItem_type" -> {
                return String.valueOf(nbtItem.getType());
            }
            case "heldItem_id" -> {
                return String.valueOf(nbtItem.getString("MMOITEMS_ITEM_ID"));
            }
            case "heldItem_tier" -> {
                return String.valueOf(nbtItem.getString("MMOITEMS_TIER"));
            }
            case "heldItem_set" -> {
                return String.valueOf(nbtItem.getString("MMOITEMS_ITEM_SET"));
            }
            case "heldItem_canUse" -> {
                PlayerData playerdata = PlayerData.get(player);
                return String.valueOf(playerdata.getRPG().canUse(nbtItem, false));
            }
        }
        return null;
    }

}
