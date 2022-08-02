package com.henos.realistic_combat.mixin;

import com.henos.realistic_combat.Debuff.debuff;
import com.henos.realistic_combat.RealisticCombatMain;
import net.minecraft.item.Item;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public class PlayerTickMixin {
    @Inject(method = "tick", at = @At(value = "HEAD"))
    protected void tick(CallbackInfo ci) {
        if (RealisticCombatMain.isDev()) {
            RealisticCombatMain.LOGGER.info("ticked");
        }
        ServerPlayerEntity spe = ((ServerPlayerEntity) (Object) this);
        debuff.tick(spe);
    }
}