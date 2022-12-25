package de.Ng.Wuppy.Client.Handler;

import de.Ng.Wuppy.Client.Client;
import de.Ng.Wuppy.Client.PacketSerializer;
import de.Ng.Wuppy.Client.Packets.Packet;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class PacketEncoder extends MessageToByteEncoder<Packet> {
	
	@Override
	protected void encode(ChannelHandlerContext ctx, Packet packet, ByteBuf output) throws Exception {
		int id = Client.OUT_PACKETS.indexOf(packet.getClass());
		if(id == -1)
			throw new NullPointerException("Couldn't find id of packet " + packet.getClass().getSimpleName());
		PacketSerializer packetSerializer = new PacketSerializer(output);
		packetSerializer.writeVarInt(id);
		packet.write(packetSerializer);
	}
}