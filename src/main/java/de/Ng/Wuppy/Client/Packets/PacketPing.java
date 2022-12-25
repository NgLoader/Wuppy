package de.Ng.Wuppy.Client.Packets;

import java.io.IOException;

import de.Ng.Wuppy.Client.PacketSerializer;

public class PacketPing implements Packet {
	
	public long time;
	
	public PacketPing() { }
	
	public PacketPing(long time) {
		this.time = time;
	}
	
	@Override
	public void read(PacketSerializer packetSerializer) throws IOException {
		this.time = packetSerializer.readLong();
	}
	
	@Override
	public void write(PacketSerializer packetSerializer) throws IOException {
		packetSerializer.writeLong(this.time);
	}
}