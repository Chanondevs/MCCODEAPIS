package me.chanondevs.mccodeapi;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Inventoria implements Listener {

	private HashMap<Player,Long> click = new HashMap<>();
	private HashMap<Player,ClickedType> type = new HashMap<>();
	private HashMap<Player,Long> tripple = new HashMap<>();
	@EventHandler
	public void doubleclick(InventoryClickEvent e) {
		Player p = (Player)e.getWhoClicked();
		if(tripple.containsKey(p) ) {
			if(System.currentTimeMillis() - tripple.get(p) <= 210) {
				Bukkit.getServer().getPluginManager().callEvent(new InventoryClickByOrzEvent(p, e.getInventory(), e.getRawSlot(), ClickedType.LEFT_TRIPPLE_CLICK));
				return;
			}else {
				tripple.remove(p);
			}
		}
		ClickedType ct = ClickedType.UNKNOW;
		if(!e.isShiftClick() && e.isLeftClick()) ct = ClickedType.LEFT;
		if(!e.isShiftClick() && e.isRightClick()) ct = ClickedType.RIGHT;
		if(e.isShiftClick() && e.isLeftClick()) ct = ClickedType.SHIFT_LEFT_CLICK;
		if(e.isShiftClick() && e.isRightClick()) ct = ClickedType.SHIFT_RIGHT_CLICK;
		if(!e.isShiftClick() && e.getClick() == ClickType.MIDDLE) ct = ClickedType.MIDDLE;
		
		if(!type.containsKey(p)) {
			type.put(p, ct);
		}
		
		if(!click.containsKey(p)) {
			
			Bukkit.getServer().getPluginManager().callEvent(new InventoryClickByOrzEvent(p, e.getInventory(), e.getRawSlot(), ct));
			click.put(p, System.currentTimeMillis());
		}
		else if(click.containsKey(p)) {
			if(type.get(p).equals(ct) && System.currentTimeMillis() - click.get(p) <= 210 ) {
				
				if(!e.isShiftClick() && ct.equals(ClickedType.LEFT))ct = ClickedType.LEFT_DOUBLE_CLICK;
				if(!e.isShiftClick() && ct.equals(ClickedType.RIGHT))ct = ClickedType.RIGHT_DOUBLE_CLICK;
				if(e.isShiftClick() && ct.equals(ClickedType.SHIFT_LEFT_CLICK))ct = ClickedType.SHIFT_LEFT_DOUBLE_CLICK;
				if(e.isShiftClick() && ct.equals(ClickedType.SHIFT_RIGHT_CLICK))ct = ClickedType.SHIFT_RIGHT_DOUBLE_CLICK;
				
				Bukkit.getServer().getPluginManager().callEvent(new InventoryClickByOrzEvent(p, e.getInventory(), e.getRawSlot(), ct));
				click.remove(p);
				type.remove(p);
				tripple.put(p, System.currentTimeMillis());
			}
			else {

				Bukkit.getServer().getPluginManager().callEvent(new InventoryClickByOrzEvent(p, e.getInventory(), e.getRawSlot(), ct));
				type.put(p, ct);
				click.put(p, System.currentTimeMillis());
				
			}
		}
		
		
	}
	
}
