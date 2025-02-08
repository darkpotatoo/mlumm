package darkpotatoo.mlumm;

import com.mojang.logging.LogUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.slf4j.Logger;

public class Iteminfo {

    private static final Logger LOGGER = LogUtils.getLogger();

    public static void ItemInfoDisplay() {
        LOGGER.info("Attempting to display iteminfo");
        MinecraftClient client = MinecraftClient.getInstance();
        if (client != null && client.player != null) {
            ItemStack hoveredItem = client.player.currentScreenHandler.getCursorStack();
            if (!hoveredItem.isEmpty()) {
                NbtCompound nbt = hoveredItem.getNbt();
                if (nbt != null) {
                    LOGGER.info("Item NBT: " + nbt.toString());
                } else {
                    LOGGER.info("Item has no NBT data.");
                }
            } else {
                LOGGER.info("No item to display info for");
            }
        }
    }
}