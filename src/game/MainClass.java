package game;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class MainClass {
	
	/***   game management methods   ***/
	public static Place changePlace(World gameWorld, Place currentPlace, String direction, ActiveEntity player)
	{
		Place nextPlace = gameWorld.getPlaceInDirection(currentPlace, direction);
		Point nextPlaceEntrancePoint = nextPlace.getEntrancePoint(direction);
		if (nextPlace.equals(null))
		{
			System.out.println("Place not found.");
		}
		else if (!nextPlaceEntrancePoint.equals(new Point(-1,-1)))
		{
			System.out.println("You can't go there.");
		}
		else
		{
			currentPlace.removeEntity(player.getEntityPoint());
			nextPlace.addEntity((Entity)player, nextPlaceEntrancePoint);//<--twice?
			return nextPlace;
		}
		return currentPlace;
	}
	
	/*** combat methods ***/
	public static int getCalculatedDamage(Place currentPlace, Entity attacker, Entity attackee)
	{	
		double distance = currentPlace.getDistance(attacker, attackee);
		int armorStrengthTotal = attackee.getInventory().getTotalArmorStrength();
		Weapon attackerWeapon = attacker.getInventory().getActiveWeapons(0);
		int range = attackerWeapon.getRange();
		int damage = attackerWeapon.getDamage();
		return (Math.abs((int)distance - range) + damage - armorStrengthTotal);
		
		//update this method as testing goes on.
		//distance - effect depends on range and kind of weapon
		//armor - calculated damage varies inversely
		//myRange - optimal distance for maximum damage
		//myDamage - overall effectiveness of weapon. multiple or divide final int by this.
		//possible tweaks:
		//range/dist (highest/lowest or opposite. if statement will set it to ensure it is always
		//a fraction or double/int greater than 1.)
		//multiply by damage
		//divide by armorStrengthTotal
	}
	
	public static void main(String[] Args) throws IOException
	{
		int worldSizeLine = 0;
		int placeSizeLine = 1;
		int currentPlaceLine = 2;
		int currentLocationLine = 3;
		int weaponLimitLine = 5;
		int armorLimitLine = 6;
		int potionLimitLine = 7;

		List<String> lines = Files.readAllLines(Paths.get(MainClass.class.getResource("/") + "game.txt"), StandardCharsets.UTF_8);
		String currentPlaceCoords = lines.get(currentPlaceLine).substring(lines.get(currentPlaceLine).indexOf(" "));
		Place currentPlace = new Place(Paths.get(MainClass.class.getResource("/") + "locations/(" + currentPlaceCoords + ").txt"));
		ActiveEntity player = new ActiveEntity(Paths.get(MainClass.class.getResource("/") + "player.txt"));
	}
}
