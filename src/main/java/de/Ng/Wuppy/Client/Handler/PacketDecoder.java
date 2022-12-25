package de.Ng.Wuppy.Client.Handler;

import java.util.List;

import de.Ng.Wuppy.Client.Client;
import de.Ng.Wuppy.Client.PacketSerializer;
import de.Ng.Wuppy.Client.Packets.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class PacketDecoder extends ByteToMessageDecoder {
	
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf byteBuf, List<Object> output) throws Exception {
		PacketSerializer packetSerializer = new PacketSerializer(byteBuf);
		int id = packetSerializer.readVarInt();
		Class<? extends Packet> packetClass = Client.IN_PACKETS.get(id);
		if(packetClass == null)
			throw new NullPointerException("Couldn't find packet by id " + id);
		Packet packet = packetClass.newInstance();
		packet.read(packetSerializer);
		output.add(packet);
	}
}