package darkpotatoo.mlumm.mixin.client;

import com.mojang.logging.LogUtils;
import darkpotatoo.mlumm.MlummClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.toast.SystemToast;
import net.minecraft.client.toast.ToastManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class TickMixin {

    @Shadow @Final private ToastManager toastManager;
    private static final Logger LOGGER = LogUtils.getLogger();

    @Inject(method = "tick", at = @At("HEAD"))
    private void onTick(CallbackInfo info) {
        //something else here

        //combat timer stuff
        MinecraftClient client = MinecraftClient.getInstance();
        PlayerEntity player = client.player;
        if (MlummClient.combatTicks > 0) {
            MlummClient.combatTicks--;
            if (MlummClient.combatTicks == 0) {
                LOGGER.info("COMBAT/Timer Done");
                player.sendMessage(Text.of("§a» §fCombat timber has ended"), false);
                sendCustomToast(client, "Combat Timer Ended", "You are now out of combat");
            }
        }
    }

    //Custom Toast
    private void sendCustomToast(MinecraftClient client, String text, String text2) {
        ToastManager toastManager = client.getToastManager();
        toastManager.add(new SystemToast(SystemToast.Type.TUTORIAL_HINT, Text.of(text), Text.of(text2)));
    }
}