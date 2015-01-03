package mgt.xjboss.WrenchBreakProtect;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
public class Event implements Listener {
	Main main=null;
	Event(Main plugin){
		main=plugin;
	}
	@EventHandler
	public void WrenchBreakProtect (PlayerInteractEvent event){
		if(!event.getPlayer().hasPermission("WrenchBreakProtect.allowbreak")){
			if(event.getAction()==Action.RIGHT_CLICK_BLOCK){
				Material BlockType=event.getClickedBlock().getType();
				if((BlockType==Material.PISTON_STICKY_BASE)|(BlockType==Material.PISTON_BASE)){
					String I=event.getPlayer().getItemInHand().getType().name();
					String S=String.valueOf(event.getPlayer().getItemInHand().getData().getData());
					String itemname=I+":"+S;
					if(main.checkWrench(itemname)){
						//event.getPlayer().sendMessage("You can't do this");
						event.setCancelled(true);
					}
				}
			}
		}
	}
}
