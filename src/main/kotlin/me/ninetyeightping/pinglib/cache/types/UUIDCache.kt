package me.ninetyeightping.pinglib.cache.types

import me.ninetyeightping.pinglib.PingLib
import me.ninetyeightping.pinglib.cache.Cache
import org.bukkit.entity.Player
import java.util.*

object UUIDCache : Cache<String, UUID>() {

    fun addPlayerToUUIDCache(player: Player)
    {
        this.cacheMap[player.name] = player.uniqueId

        PingLib.instance.jedis.resource.hset("PingLib:uuidcache:", player.name, player.uniqueId.toString())
    }

    fun loadFromJedis() {
        for (entry in PingLib.instance.jedis.resource.hgetAll("PingLib:uuidcache:"))
        {
            cacheMap[entry.key] = UUID.fromString(entry.value)
        }
    }

    override fun AbyB(b: UUID) : String? {
       for (entry in this.cacheMap.entries)
       {
           if (entry.value == b) {
               return entry.key
           }
       }
        return null
    }

    override fun BbyA(a: String) : UUID? {
        return this.cacheMap[a]
    }
}