package me.takkapi.technopigs.listener;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Listeners implements Listener {
    public Listeners() {
    }

    public ItemStack getItem() {
        ItemStack hoe = new ItemStack(Material.GOLDEN_HOE);
        ItemMeta meta = hoe.getItemMeta();
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        hoe.setItemMeta(meta);
        return hoe;
    }

    @EventHandler
    public void spawn(CreatureSpawnEvent e) {
        if (e.getEntityType() == EntityType.ZOMBIFIED_PIGLIN) {
            PigZombie pigman = (PigZombie)e.getEntity();
            pigman.getEquipment().setItemInMainHand(new ItemStack(this.getItem()));
            pigman.getEquipment().setItemInOffHand(new ItemStack(Material.POTATO));
        }

    }
}
