package xd.festajunina.item.custom;

import net.minecraft.nbt.NbtCompound;

public interface NBTHandler {

    void readNbt(NbtCompound nbt);

    NbtCompound writeNbt(NbtCompound nbt);
}
