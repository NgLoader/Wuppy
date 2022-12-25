package de.Ng.Wuppy.Client.Packets.Global;

import java.io.IOException;

import de.Ng.Wuppy.Client.PacketSerializer;
import de.Ng.Wuppy.Client.Packets.Packet;

public class GlobalMessagePacket implements Packet {
	
	public String message;
	
	public GlobalMessagePacket() { }
	
	public GlobalMessagePacket(String message) {
		this.message = message;
	}
	
	@Override
	public void read(PacketSerializer packetSerializer) throws IOException {
		this.message = packetSerializer.readString();
	}
	
	@Override
	public void write(PacketSerializer packetSerializer) throws IOException {
		packetSerializer.writeString(message);
	}
}