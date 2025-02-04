package darkpotatoo.mlumm;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class Item {

    private static final Logger LOGGER = LogUtils.getLogger();

    public String name;
    public int chocoCost;
    public String[] craftingRecipe;
    public String howto;

    public Item(String _name, int _chocoCost, String[] _craftingRecipe, String _howto) {
        name = _name;
        chocoCost = _chocoCost;
        craftingRecipe = _craftingRecipe;
        howto = _howto;
        LOGGER.info("Item '" + name + "' registered");
    }

    public static void InitItems(){
        Item baton = new Item(
                "Baton",
                0,
                new String[]{"Cannot be crafted"},
                "Dropped by guard");

    }

}
