package com.aquabarnes.spiritedaway.init;

import java.util.HashMap;
import java.util.UUID;

public class SARanks
{
  public static HashMap<String, UUID> ranks = new HashMap();
  
  public static void initialization()
  {
    addDeveloperRank("c7b62bb0-8a7a-41f8-a9d9-812c89ee9c99");
    
    addTesterRank("c361a4ce-9961-4b6f-bb34-c04da5316680");
    addTesterRank("2891d5d1-8fc7-4afd-a866-05c38078a5dd");
    addTesterRank("2ae3627a-5eba-46f7-9c29-3119ae41c4ef");
    
    addTesterRank("b6310a91-919e-4f31-920b-42dbc15957a8");
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
 
    if (ranks.get("Spirited Away Tester-" + uuid.toString()) != null) {
        return true;
    }
    return false;
  }
  
  public static void addDeveloperRank(String uuid)
  {
    ranks.put("Spirited Away Developer-" + uuid, getUUID(uuid));
  }
  
  public static void addTesterRank(String uuid)
  {
    ranks.put("Spirited Away Tester-" + uuid, getUUID(uuid)); 
  }
  
  public static void addFriendRank(String uuid)
  {
    ranks.put("Spirited Away Friend-" + uuid, getUUID(uuid)); 
  }
  
}
