package xd.festajunina.item.custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BingoNumberItem extends Item {

    private final static String NUMBER_KEY = "Number";
    private final static String MARKED_KEY = "Marked";

    public BingoNumberItem(Settings settings) {
        super(settings);
    }

    public static int getNumber(ItemStack stack) {
        return stack.getOrCreateNbt().getInt(NUMBER_KEY);
    }

    public static void setNumber(ItemStack stack, int number) {
        stack.getOrCreateNbt().putInt(NUMBER_KEY, number);
    }

    public static boolean isMarked(ItemStack stack) {
        return stack.getOrCreateNbt().getBoolean(MARKED_KEY);
    }

    public static void setMarked(ItemStack stack, boolean marked) {
        stack.getOrCreateNbt().putBoolean(MARKED_KEY, marked);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.of("Number " + getNumber(stack)));
    }
}
