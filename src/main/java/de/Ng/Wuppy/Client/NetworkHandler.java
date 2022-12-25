package de.Ng.Wuppy.Client;

import java.text.SimpleDateFormat;

import de.Ng.Wuppy.Wuppy;
import de.Ng.Wuppy.Client.Packets.Packet;
import de.Ng.Wuppy.Client.Packets.PacketPing;
import de.Ng.Wuppy.Client.Packets.Global.GlobalMessagePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class NetworkHandler extends SimpleChannelInboundHandler<Packet> {
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Packet inPacket) throws Exception {
		System.out.println("Became -> " + inPacket.toString());
		if(inPacket instanceof PacketPing)
			ctx.writeAndFlush(inPacket, ctx.voidPromise());
		else if(inPacket instanceof GlobalMessagePacket) {
			GlobalMessagePacket packet = (GlobalMessagePacket)inPacket;
			EntityPlayerSP player = Minecraft.getMinecraft().player;
			
			if(player != null && player.world != null)
				player.sendMessage(new TextComponentString(Wuppy.PREFIX + "Du hast eine nachricht: " + TextFormatting.GREEN + packet.message));
		}
	}
}