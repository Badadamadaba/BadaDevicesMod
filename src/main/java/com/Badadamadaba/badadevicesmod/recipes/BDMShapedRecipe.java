package com.Badadamadaba.badadevicesmod.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IRecipeFactory;
import net.minecraftforge.common.crafting.JsonContext;

public class BDMShapedRecipe extends ShapedRecipes
{
    public BDMShapedRecipe(String group, int width, int height, NonNullList<Ingredient> ingredients, ItemStack result) {
		super(group, width, height, ingredients, result);
	}

	public boolean matches(InventoryCrafting inv, World worldIn)
    {
        for (int i = 0; i <= inv.getWidth() - this.recipeWidth; ++i)
        {
            for (int j = 0; j <= inv.getHeight() - this.recipeHeight; ++j)
            {
                if (this.checkMatch(inv, i, j, true))
                {
                    return true;
                }

                if (this.checkMatch(inv, i, j, false))
                {
                    return true;
                }
            }
        }

        return false;
    }
    
    protected boolean checkMatch(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
    {
        for (int i = 0; i < p_77573_1_.getWidth(); ++i)
        {
            for (int j = 0; j < p_77573_1_.getHeight(); ++j)
            {
                int k = i - p_77573_2_;
                int l = j - p_77573_3_;
                Ingredient ingredient = Ingredient.EMPTY;

                if (k >= 0 && l >= 0 && k < this.recipeWidth && l < this.recipeHeight)
                {
                    if (p_77573_4_)
                    {
                        ingredient = this.recipeItems.get(this.recipeWidth - k - 1 + l * this.recipeWidth);
                    }
                    else
                    {
                        ingredient = this.recipeItems.get(k + l * this.recipeWidth);
                    }
                }

                if (!ingredient.apply(p_77573_1_.getStackInRowAndColumn(i, j)))
                {
                    return false;
                }
            }
        }

        return true;
    }
    
    public abstract static class ShapedFactory implements IRecipeFactory {
        public ShapedFactory() {
        }

        public IRecipe parse(JsonContext context, JsonObject json) {
            String group = JsonUtils.getString(json, "group", "");
            Map<Character, Ingredient> ingMap = Maps.newHashMap();
            Iterator var5 = JsonUtils.getJsonObject(json, "key").entrySet().iterator();

            while(var5.hasNext()) {
                Entry<String, JsonElement> entry = (Entry)var5.next();
                if (((String)entry.getKey()).length() != 1) {
                    throw new JsonSyntaxException("Invalid key entry: '" + (String)entry.getKey() + "' is an invalid symbol (must be 1 character only).");
                }

                if (" ".equals(entry.getKey())) {
                    throw new JsonSyntaxException("Invalid key entry: ' ' is a reserved symbol.");
                }

                ingMap.put(((String)entry.getKey()).toCharArray()[0], CraftingHelper.getIngredient((JsonElement)entry.getValue(), context));
            }

            ingMap.put(' ', Ingredient.EMPTY);
            JsonArray patternJ = JsonUtils.getJsonArray(json, "pattern");
            if (patternJ.size() == 0) {
                throw new JsonSyntaxException("Invalid pattern: empty pattern not allowed");
            } else if (patternJ.size() > 3) {
                throw new JsonSyntaxException("Invalid pattern: too many rows, 3 is maximum");
            } else {
                String[] pattern = new String[patternJ.size()];

                for(int x = 0; x < pattern.length; ++x) {
                    String line = JsonUtils.getString(patternJ.get(x), "pattern[" + x + "]");
                    if (line.length() > 3) {
                        throw new JsonSyntaxException("Invalid pattern: too many columns, 3 is maximum");
                    }

                    if (x > 0 && pattern[0].length() != line.length()) {
                        throw new JsonSyntaxException("Invalid pattern: each row must be the same width");
                    }

                    pattern[x] = line;
                }

                NonNullList<Ingredient> input = NonNullList.withSize(pattern[0].length() * pattern.length, Ingredient.EMPTY);
                Set<Character> keys = Sets.newHashSet(ingMap.keySet());
                keys.remove(' ');
                int x = 0;
                String[] var10 = pattern;
                int var11 = pattern.length;

                for(int var12 = 0; var12 < var11; ++var12) {
                    String line = var10[var12];
                    char[] var14 = line.toCharArray();
                    int var15 = var14.length;

                    for(int var16 = 0; var16 < var15; ++var16) {
                        char chr = var14[var16];
                        Ingredient ing = (Ingredient)ingMap.get(chr);
                        if (ing == null) {
                            throw new JsonSyntaxException("Pattern references symbol '" + chr + "' but it's not defined in the key");
                        }

                        input.set(x++, ing);
                        keys.remove(chr);
                    }
                }

                if (!keys.isEmpty()) {
                    throw new JsonSyntaxException("Key defines symbols that aren't used in pattern: " + keys);
                } else {
                    ItemStack result = CraftingHelper.getItemStack(JsonUtils.getJsonObject(json, "result"), context);
                    return this.initRecipe(group, pattern[0].length(), pattern.length, input, result);
                }
            }
        }

        public abstract IRecipe initRecipe(String var1, int var2, int var3, NonNullList<Ingredient> var4, ItemStack var5);
		}
}