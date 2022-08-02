package com.henos.realistic_combat.Debuff;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

public class debuff {
    public static void tick(ClientPlayerEntity cpe) {
        if (cpe.getHealth() == 20) {
            return;
        } if (cpe.getHealth() >= 15) {
            // weakness
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 1));
        } if (cpe.getHealth() >= 12) {
            // weakness
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 2));
            // slowness
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(2), 1, 1));
        } if (cpe.getHealth() >= 10) {
            // weakness
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(18), 1, 3));
            // slowness
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(2), 1, 2));
            // nausea
            cpe.addStatusEffect(new StatusEffectInstance(StatusEffect.byRawId(9), 1, 1));
            // collapse
            cpe.setPose(EntityPose.SWIMMING);
        }
    }
}
