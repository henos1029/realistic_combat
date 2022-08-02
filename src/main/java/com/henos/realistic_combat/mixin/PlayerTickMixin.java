package com.henos.realistic_combat.mixin;

import com.henos.realistic_combat.Debuff.debuff;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.apache.commons.compress.harmony.pack200.NewAttributeBands;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerEntity.class)
public class PlayerTickMixin {
    @Inject(method = "tick", at = @At(value = "HEAD"))
    protected void tick(CallbackInfo ci) {
        ClientPlayerEntity cpe = ((ClientPlayerEntity) (Object) this);
        debuff.tick(cpe);
    }
}
