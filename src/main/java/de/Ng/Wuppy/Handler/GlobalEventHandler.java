package de.Ng.Wuppy.Handler;

import de.Ng.Wuppy.Client.Client;
import de.Ng.Wuppy.Client.Packets.Global.GlobalMessagePacket;
import de.Ng.Wuppy.Gui.GuiWuppy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GlobalEventHandler {
	
	public static Minecraft mc = Minecraft.getMinecraft();
	
	public static GuiWuppy guiWuppy = new GuiWuppy();

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onChat(ClientChatEvent event) {
		if(event.getMessage().startsWith("/wuppy")) {
			event.setCanceled(true);
			Client.getInstance().sendPacket(new GlobalMessagePacket(event.getMessage().substring(7)));
		} else if(event.getMessage().startsWith("/connect")) {
			event.setCanceled(true);
			
			new Thread(() -> {
				try {
					Client.getInstance().connect();
				} catch(Exception ex) {
					ex.printStackTrace();
				}
			}).start();
		} else if(event.getMessage().startsWith("/disconnect")) {
			event.setCanceled(true);
			Client.getInstance().disconnect();
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void openGui(GuiOpenEvent event) {
		if(event.getGui() instanceof GuiMainMenu)
			event.setGui(guiWuppy);
	}
}