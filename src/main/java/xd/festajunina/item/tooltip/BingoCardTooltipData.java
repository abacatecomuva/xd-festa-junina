package xd.festajunina.item.tooltip;

import net.minecraft.client.item.TooltipData;
import net.minecraft.item.ItemStack;

import java.util.List;

public record BingoCardTooltipData(List<ItemStack> inventory) implements TooltipData {
}
