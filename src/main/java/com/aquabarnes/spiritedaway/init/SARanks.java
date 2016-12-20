package com.aquabarnes.spiritedaway.init;

import java.util.HashMap;
import java.util.UUID;

public class SARanks
{
  public static HashMap<String, UUID> ranks = new HashMap();
  
  public static void initialization()
  {
    addDeveloperRank("c7b62bb0-8a7a-41f8-a9d9-812c89ee9c99");
  }
  
  public static UUID getUUID(String string)
  {
    return UUID.fromString(string);
  }
  
  public static boolean isRankedPlayer(UUID uuid)
  {
    if (ranks.get("Spirited Away Developer-" + uuid.toString()) != null) {
      return true;
    }
    return false;
  }
  
  public static void addDeveloperRank(String uuid)
  {
    ranks.put("Spirited Away Developer-" + uuid, getUUID(uuid));
  }
  
}
