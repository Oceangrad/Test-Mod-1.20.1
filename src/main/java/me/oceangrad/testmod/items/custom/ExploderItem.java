package me.oceangrad.testmod.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ExploderItem extends Item {

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if(user.getItemCooldownManager().isCoolingDown(stack.getItem()))
            return ActionResult.FAIL;

        entity.getWorld().createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), 10.0f, true, World.ExplosionSourceType.MOB);
        user.getItemCooldownManager().set(stack.getItem(), 100);

        return ActionResult.success(true);
    }

    public ExploderItem(Settings settings) {
        super(settings);
    }
}
