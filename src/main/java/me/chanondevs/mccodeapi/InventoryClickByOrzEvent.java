package me.chanondevs.mccodeapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.Inventory;

public class InventoryClickByOrzEvent extends Event implements Cancellable{

	private static final HandlerList handlers = new HandlerList();
	private Player p;
	private Inventory inv;
	private int slot;
	private ClickedType clickType;
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public InventoryClickByOrzEvent(Player p,Inventory inv,int slot,ClickedType click) {
		this.p = p;
		this.inv = inv;
		this.slot = slot;
		this.clickType = click;
	}
	
	public ClickedType getClick() {
		return clickType;
	}
	
	public Inventory getInventory() {
		return inv;
	}
	
	public int getRawSlot() {
		return slot;
	}
	
	public Player getWhoClicked() {
		return p;
	}

	private boolean cancel = false;
	@Override
	public boolean isCancelled() {
		return cancel;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
		
	}

}
