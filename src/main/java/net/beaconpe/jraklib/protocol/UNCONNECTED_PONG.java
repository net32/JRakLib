/**
 * JRakLib is not affiliated with Jenkins Software LLC or RakNet.
 * This software is a port of RakLib https://github.com/PocketMine/RakLib.

 * This file is part of JRakLib.
 *
 * JRakLib is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JRakLib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JRakLib.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.beaconpe.jraklib.protocol;

import net.beaconpe.jraklib.JRakLib;

/**
 * Packet that advertises the server to the client.
 */
public class UNCONNECTED_PONG extends Packet{
    public static byte ID = 0x1c;

    public long pingID;
    public long serverID;
    public String serverName;

    public byte getID() {
        return 0x1c;
    }

    @Override
    protected void _encode() {
        putLong(pingID);
        putLong(serverID);
        put(JRakLib.MAGIC);
        putString(serverName);
    }

    @Override
    protected void _decode() {
        pingID = getLong();
        serverID = getLong();
        offset = offset + 16; //magic
        serverName = getString();
    }
}
