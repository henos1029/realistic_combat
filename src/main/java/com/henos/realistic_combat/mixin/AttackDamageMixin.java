package com.henos.realistic_combat.mixin;

import com.henos.realistic_combat.Item.Item;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class AttackDamageMixin {
    @Inject(method = "attack()V", at = @At(value = "INVOKE", target = "net/minecraft/entity/Entity;damage()B"))
    public void changeDamage(float l, CallbackInfo ci) {
        
        l += Item.getWeight("hi");

    }
}
