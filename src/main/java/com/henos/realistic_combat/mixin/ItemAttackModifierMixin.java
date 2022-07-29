package com.henos.realistic_combat.mixin;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.henos.realistic_combat.Item.Weights;
import com.henos.realistic_combat.RealisticCombatMain;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import java.util.Random;
import java.util.UUID;

@Mixin(Item.class)
public class ItemAttackModifierMixin {
    @Inject(method = "getAttributeModifiers", at = @At(value = "RETURN"), cancellable = true)
    protected void attackDamage(EquipmentSlot slot, CallbackInfoReturnable<Multimap<EntityAttribute, EntityAttributeModifier>> cir) {
        Item item = ((Item) (Object) this);
//        RealisticCombatMain.LOGGER.info("getAttributeModifiers() called");
        if (Weights.check_id(item)) {
            if (slot.getType() == EquipmentSlot.Type.HAND) {
                UUID ATTACK_DAMAGE_MODIFIER_ID = MathHelper.randomUuid();
                ImmutableMultimap.Builder<EntityAttribute, EntityAttributeModifier> builder = ImmutableMultimap.builder();
                RealisticCombatMain.LOGGER.info("Edited Attack Damage for " + Registry.ITEM.getId(item) + " " + Weights.getWeight(item));
                cir.setReturnValue(builder.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_ID, "Base Attack Damage Modifier", Weights.getWeight(item), EntityAttributeModifier.Operation.ADDITION)).build());
            }
        }
    }
}