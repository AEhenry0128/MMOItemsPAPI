package io.aehenry.mmoitempapi;

import io.lumine.mythic.api.adapters.AbstractEntity;
import io.lumine.mythic.api.config.MythicLineConfig;
import io.lumine.mythic.api.skills.conditions.IEntityCondition;
import io.lumine.mythic.bukkit.events.MythicConditionLoadEvent;
import io.lumine.mythic.core.skills.SkillCondition;
import io.lumine.mythic.core.utils.annotations.MythicCondition;
import io.lumine.mythic.lib.api.item.NBTItem;
import net.Indyuce.mmoitems.api.player.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@MythicCondition(author = "AEhenry", name = "isMMOItem")
public class MyhicMobCondition extends SkillCondition implements IEntityCondition {

    private final String ITEM;
    private final String TYPE;
    private final String TIER;
    private final boolean USABLE;

    public MyhicMobCondition(MythicConditionLoadEvent event) {

        super(event.getConfig().getLine());
        MythicLineConfig mlc = event.getConfig();

        this.TYPE = mlc.getString(new String[]{"type", "t"},null);
        this.ITEM = mlc.getString(new String[]{"item", "i"},null);
        this.TIER = mlc.getString(new String[]{"tier"},null);
        this.USABLE = mlc.getBoolean(new String[]{"usable", "r"},false);
    }

    @Override
    public boolean check(AbstractEntity entity) {

        if (!entity.isPlayer()) return false;

        Player player = (Player) entity.getBukkitEntity();
        ItemStack handItem = player.getInventory().getItemInMainHand();
        if (handItem.getType().isAir()) return false;

        NBTItem nbtItem = NBTItem.get(handItem);
        if (!nbtItem.hasType()) return false;

        PlayerData playerdata = PlayerData.get(player);

        if (TYPE != null && !nbtItem.getType().equals(TYPE)) return false;
        if (ITEM != null && !nbtItem.getString("MMOITEMS_ITEM_ID").equals(ITEM)) return false;
        if (TIER != null && !nbtItem.getString("MMOITEMS_TIER").equals(TIER)) return false;
        if (USABLE && !playerdata.getRPG().canUse(nbtItem,false)) return false;

        return true;
    }
}
