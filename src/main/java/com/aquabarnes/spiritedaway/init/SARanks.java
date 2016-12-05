package com.aquabarnes.spiritedaway.init;

import com.aquabarnes.spiritedaway.SpiritedAway;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.ArrayList;
import java.util.UUID;

public enum SARanks {

	  DEVELOPER("Developer", SpiritedAway.Developer, 2342342),  HELPER("Helper", SpiritedAway.Helper, 2344),  DONATER("", new ArrayList(), 0),  DEFAULT("", new ArrayList(), 0);
	  
	  private ArrayList<UUID> Members = new ArrayList();
	  private int DescriptionColor;
	  private String Description;

	  public static void init() {
		  
		  addRanks();
	  }
	  	  
	  public static void addRanks()
	  {
		  SpiritedAway.Developer.add(EntityPlayerMP.getOfflineUUID("Player273"));
		  //TODO: RANKS
		  //AQUABARNES
		  //UUID.fromString("c7b62bb0-8a7a-41f8-a9d9-812c89ee9c99"))
		  //KARZIA
		  //UUID.fromString("c361a4ce-9961-4b6f-bb34-c04da5316680"))
          //SPACEDRAGONZ
          //UUID.fromString("2891d5d1-8fc7-4afd-a866-05c38078a5dd"))
          //BENBUCK
          //UUID.fromString("2ae3627a-5eba-46f7-9c29-3119ae41c4ef"))
          //ALANBECKER
          //UUID.fromString("13655ac1-584d-4785-b227-650308195121")) //LOOKUP
	  }
	  
	  private SARanks(String description, ArrayList<UUID> members, int descriptionColor)
	  {
		  this.Members = members;
		  this.Description = description;
		  this.DescriptionColor = descriptionColor;
	  }

	  public int getDescriptionColor()
	  {
		  return this.DescriptionColor;
	  }

	  public String getDescription()
	  {
		  return this.Description;
	  }

	  public static SARanks getRankFromMember(UUID member)
	  {
		  for (int i = 0; i < values().length; i++) {
			  if (values()[i].getMembers().contains(member)) {
				  return values()[i];
			  }
		  }
		  return DEVELOPER;
}

	  public ArrayList<UUID> getMembers()
	  {
		  return this.Members;
	  }	
}
