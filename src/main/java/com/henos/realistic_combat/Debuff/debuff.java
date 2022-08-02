package com.henos.realistic_combat.Debuff;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class debuff {
    public static void tick(ServerPlayerEntity spe) {
        if (spe.getHealth() == 20) {
            return;
        } if (spe.getHealth() >= 15) {
            // weakness
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 1));
        } if (spe.getHealth() >= 12) {
            // weakness
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 2));
            // slowness
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(2), 1, 1));
        } if (spe.getHealth() >= 10) {
            // weakness
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 3));
            // slowness
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(2), 1, 2));
            // nausea
            spe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(9), 1, 1));
            // collapse
            spe.setPose(EntityPose.SWIMMING);
        }
    }
}
