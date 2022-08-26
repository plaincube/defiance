package bastion.defiantce.module;

import java.util.ArrayList;

import bastion.defiantce.Defiant;
import bastion.defiantce.module.combat.*;
import bastion.defiantce.module.movement.*;
import bastion.defiantce.module.player.*;
import bastion.defiantce.module.render.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

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
		newMod(new Glide());
		newMod(new JumpLock());
		newMod(new SneakLock());
		newMod(new SpeedHack());
		newMod(new SprintLock());
		newMod(new UnlimitedJumps());
		newMod(new WalkLock());
		newMod(new WallClimb());
		newMod(new WaterBobbing());
		
		//PLAYER
		newMod(new AntiAFK());
		newMod(new AntiCobweb());
		newMod(new AutoMine());
		newMod(new AutoRespawn());
		newMod(new FastLadder());
		newMod(new FastUse());
		
		//RENDER
		newMod(new ClickGui());
		newMod(new ESP());
		newMod(new Xray());
		
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
	
	public static void addChatMessage(String message){
		message = "\u00A71" + "DefiantCE:" + "\u00A7f " + message;
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
	}
	
}
