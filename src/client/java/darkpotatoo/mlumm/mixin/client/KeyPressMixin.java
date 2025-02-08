package darkpotatoo.mlumm.mixin.client;

import darkpotatoo.mlumm.Iteminfo;
import darkpotatoo.mlumm.MlummClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class KeyPressMixin {

    @Inject(method = "handleInputEvents", at = @At("HEAD"))
    private void onHandleInputEvents(CallbackInfo ci) {
        if (MlummClient.GetItemInfoKey.wasPressed()) {
            Iteminfo.ItemInfoDisplay();
        }
    }
}