package darkpotatoo.mlumm.mixin.client;

import com.mojang.logging.LogUtils;
import darkpotatoo.mlumm.MlummClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.LivingEntity;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class DamageMixin extends LivingEntity {
    private static final Logger LOGGER = LogUtils.getLogger();

    protected DamageMixin() {
        super(null, null);
    }

    @Inject(method = "damage", at = @At("HEAD"))
    private void onDamage(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        LOGGER.info("COMBAT/Start Timer");
        MlummClient.combatTicks = 100;

    }
}