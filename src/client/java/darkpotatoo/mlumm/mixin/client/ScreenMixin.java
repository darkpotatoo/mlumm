package darkpotatoo.mlumm.mixin.client;

import darkpotatoo.mlumm.MlummClient;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
@Environment(EnvType.CLIENT)
public abstract class ScreenMixin {

    @Shadow public abstract Text getTitle();

    @Inject(method = "onDisplayed", at = @At(value = "HEAD"))
    protected void onDisplayed(CallbackInfo ci) {
        if (getTitle().getString().contains("Loot Barrel")) {
            MlummClient.crateTicks = 7200;
        }
        if (getTitle().getString().contains("Loot Desk")) {
            MlummClient.deskTicks = 7200;
        }
    }
}
