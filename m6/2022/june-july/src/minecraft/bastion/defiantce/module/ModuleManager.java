package bastion.defiantce.module;

import java.util.ArrayList;

import bastion.defiantce.module.combat.FastBow;
import bastion.defiantce.module.combat.KillAura;
import bastion.defiantce.module.movement.AutoJump;
import bastion.defiantce.module.movement.Flight;
import bastion.defiantce.module.movement.NoFallDamage;
import bastion.defiantce.module.movement.ParkourHelper;
import bastion.defiantce.module.movement.QuickLand;
import bastion.defiantce.module.movement.SneakLock;
import bastion.defiantce.module.movement.SpeedHack;
import bastion.defiantce.module.movement.SprintLock;
import bastion.defiantce.module.movement.UnlimitedJumps;
import bastion.defiantce.module.movement.WalkLock;
import bastion.defiantce.module.movement.WallClimb;
import bastion.defiantce.module.movement.WaterBobbing;
import bastion.defiantce.module.render.ClickGui;

public class ModuleManager {

	public static ArrayList<Module> mods;
	
	public ModuleManager() {
		mods = new ArrayList<Module>();
		
		//COMBAT
		newMod(new FastBow());
		newMod(new KillAura());
		
		//MOVEMENT
		newMod(new AutoJump());
		newMod(new Flight());
		newMod(new NoFallDamage());
		newMod(new ParkourHelper());
		newMod(new QuickLand());
		newMod(new SneakLock());
		newMod(new SpeedHack());
		newMod(new SprintLock());
		newMod(new UnlimitedJumps());
		newMod(new WalkLock());
		newMod(new WallClimb());
		newMod(new WaterBobbing());
		
		//PLAYER
		
		//RENDER
		newMod(new ClickGui());
		
		//MISC
	}
	
	public static void newMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules() {
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m : mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for (Module m : mods) {
			m.onRender();
		}
	}
	
	public static void onKey(int k) {
		for (Module m : mods) {
			if (m.getKey() == k) {
				m.toggle();
			}
		}
	}
	
}