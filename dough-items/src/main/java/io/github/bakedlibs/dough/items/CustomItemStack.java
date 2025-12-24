package io.github.bakedlibs.dough.items;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.Nullable;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;

/**
 * ============================================================
 * IMPORTANT — LEGACY CLASS
 * This class is NOT intended for creating item stacks.
 * It exists only for backwards compatibility.
 * <p>
 * Use {@link ItemStackFactory} for all item creation.
 * ============================================================
 *
 * @deprecated This class is NOT intended for creating item stacks,
 * it exists only for backwards compatibility.
 * Use {@link ItemStackFactory} instead.
 * Based on the implementation from commit {@code c191e24}:
 * <a href="https://github.com/womzil/dough/commit/c191e24">View on GitHub</a>.
 */

@Deprecated(forRemoval = false, since = "1.3.0")
public class CustomItemStack extends ItemStack {

    public CustomItemStack(ItemStack item) {
        super(item.getType(), item.getAmount());

        if (item.hasItemMeta()) {
            setItemMeta(item.getItemMeta());
        }
    }

    public CustomItemStack(Material type) {
        super(type);
    }

    public CustomItemStack(ItemStack item, Consumer<ItemMeta> meta) {
        super(item.getType(), item.getAmount());

        if (item.hasItemMeta()) {
            setItemMeta(item.getItemMeta());
        }

        ItemMeta im = getItemMeta();
        meta.accept(im);
        setItemMeta(im);
    }

    public CustomItemStack(Material type, Consumer<ItemMeta> meta) {
        this(new ItemStack(type), meta);
    }

    public CustomItemStack(ItemStack item, String name, String... lore) {
        this(item, im -> {
            if (name != null) {
                im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            }

            if (lore.length > 0) {
                List<String> lines = new ArrayList<>();

                for (String line : lore) {
                    lines.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                im.setLore(lines);
            }
        });
    }

    public CustomItemStack(ItemStack item, Color color, String name, String... lore) {
        this(item, im -> {
            if (name != null) {
                im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            }

            if (lore.length > 0) {
                List<String> lines = new ArrayList<>();

                for (String line : lore) {
                    lines.add(ChatColor.translateAlternateColorCodes('&', line));
                }
                im.setLore(lines);
            }

            if (im instanceof LeatherArmorMeta) {
                ((LeatherArmorMeta) im).setColor(color);
            }
            if (im instanceof PotionMeta) {
                ((PotionMeta) im).setColor(color);
            }
        });
    }

    public CustomItemStack addFlags(ItemFlag... flags) {
        ItemMeta im = getItemMeta();
        im.addItemFlags(flags);
        setItemMeta(im);

        return this;
    }

    public CustomItemStack setCustomModel(int data) {
        ItemMeta im = getItemMeta();
        im.setCustomModelData(data == 0 ? null : data);
        setItemMeta(im);

        return this;
    }

    public CustomItemStack(Material type, String name, String... lore) {
        this(new ItemStack(type), name, lore);
    }

    public CustomItemStack(Material type, String name, List<String> lore) {
        this(new ItemStack(type), name, lore.toArray(new String[lore.size()]));
    }

    public CustomItemStack(ItemStack item, List<String> list) {
        this(item, list.get(0), list.subList(1, list.size()).toArray(new String[0]));
    }

    public CustomItemStack(Material type, List<String> list) {
        this(new ItemStack(type), list);
    }

    public CustomItemStack(ItemStack item, int amount) {
        super(item.getType(), item.getAmount());

        if (item.hasItemMeta()) {
            setItemMeta(item.getItemMeta());
        }

        setAmount(amount);
    }

    public CustomItemStack(ItemStack item, Material type) {
        super(item.getType(), item.getAmount());

        if (item.hasItemMeta()) {
            setItemMeta(item.getItemMeta());
        }

        setType(type);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(ItemStack itemStack, Consumer<ItemMeta> metaConsumer) {
        return ItemStackFactory.create(itemStack, metaConsumer);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(Material material, Consumer<ItemMeta> metaConsumer) {
        return ItemStackFactory.create(material, metaConsumer);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(ItemStack item, @Nullable String name, String... lore) {
        return ItemStackFactory.create(item, name, lore);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(Material material, @Nullable String name, String... lore) {
        return ItemStackFactory.create(material, name, lore);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(Material type, @Nullable String name, List<String> lore) {
        return ItemStackFactory.create(type, name, lore);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(ItemStack item, List<String> list) {
        return ItemStackFactory.create(item, list);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(Material type, List<String> list) {
        return ItemStackFactory.create(type, list);
    }

    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(ItemStack item, int amount) {
        return ItemStackFactory.create(item, amount);
    }

    /**
     * Clones the item stack and sets its type
     *
     * @param itemStack The item
     * @param type      The new type
     * @return Returns the item with a new type
     * @deprecated Setting the type via {@link ItemStack#setType(Material)} will not be supported soon.
     */
    @Deprecated(forRemoval = false, since = "1.4.0")
    public static ItemStack create(ItemStack itemStack, Material type) {
        return ItemStackFactory.create(itemStack, type);
    }
}
