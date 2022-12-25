package de.Ng.Wuppy.Client.Packets;

import java.io.IOException;

import de.Ng.Wuppy.Client.PacketSerializer;

public interface Packet {
	
	public void read(PacketSerializer packetSerializer) throws IOException;
	public void write(PacketSerializer packetSerializer) throws IOException;
	
}