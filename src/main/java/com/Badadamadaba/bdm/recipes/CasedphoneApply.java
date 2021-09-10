package com.Badadamadaba.bdm.recipes;

import com.Badadamadaba.bdm.init.ModItems;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

public class CasedphoneApply extends BDMShapedRecipe
{
	
    public CasedphoneApply(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result)
    {
		super(group, width, height, ingredients, result);
	}

    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for (int i = 0; i < inv.getSizeInventory(); ++i)
        {
            ItemStack itemstack2 = inv.getStackInSlot(i);

            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() == ModItems.PHONECASE)
                {
                    if (!itemstack1.isEmpty())
                    {
                        return false;
                    }

                    itemstack1 = itemstack2;
                }
                else
                {
                    if (itemstack2.getItem() != ModItems.PHONE)
                    {
                        return false;
                    }

                    if (!itemstack.isEmpty())
                    {
                        return false;
                    }

                    if (itemstack2.getSubCompound("BlockEntityTag") != null)
                    {
                        return false;
                    }

                    itemstack = itemstack2;
                }
            }
        }

        if (!itemstack.isEmpty() && !itemstack1.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public ItemStack getCraftingResult(InventoryCrafting inv)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        ItemStack itemstack1 = ItemStack.EMPTY;

        for (int i = 0; i < inv.getSizeInventory(); ++i)
        {
            ItemStack itemstack2 = inv.getStackInSlot(i);

            if (!itemstack2.isEmpty())
            {
                if (itemstack2.getItem() == ModItems.PHONECASE)
                {
                    itemstack = itemstack2;
                }
                else if (itemstack2.getItem() == ModItems.PHONE)
                {
                    itemstack1 = itemstack2.copy();
                }
            }
        }
        if (itemstack1.isEmpty())
        {
            return itemstack1;
        }
        else
        {
            NBTTagCompound nbttagcompound = itemstack.getSubCompound("BlockEntityTag");
            NBTTagCompound nbttagcompound1 = nbttagcompound == null ? new NBTTagCompound() : nbttagcompound.copy();
            itemstack1.setTagInfo("BlockEntityTag", nbttagcompound1);
            return itemstack1;
        }
    }

    public ItemStack getRecipeOutput()
    {
        return ItemStack.EMPTY;
    }

    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv)
    {
        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            ItemStack itemstack = inv.getStackInSlot(i);

            if (itemstack.getItem().hasContainerItem())
            {
                nonnulllist.set(i, new ItemStack(itemstack.getItem().getContainerItem()));
            }
        }

        return nonnulllist;
    }

    public boolean isDynamic()
    {
        return true;
    }

    public boolean canFit(int width, int height)
    {
        return width * height >= 2;
    }

	 	public static class Factory extends BDMShapedRecipe.ShapedFactory
        {
		@Override
		public IRecipe initRecipe(String var1, int var2, int var3, NonNullList<Ingredient> var4, ItemStack var5) 
		{
			return new CasedphoneApply(var1, var3, var3, var4, var5);
		}
       }

}